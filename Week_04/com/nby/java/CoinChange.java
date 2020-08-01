import java.util.Arrays;

/**
 * @author nanbeiyang
 * @version CoinChange.java, v 0.1 2020/7/29 1:50 下午  Exp $$
 * @name
 */
public class CoinChange {
    int amount;
    Integer minGroup;
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        } else if (amount == 0) {
            return 0;
        }
        this.amount = amount;
        Arrays.sort(coins);
        minGroup = -1;
        dfs(coins, 0, 0);
        return minGroup;
    }

    private void dfs(int[] coins, Integer sum, Integer count) {
        if (sum == amount) {
            minGroup = minGroup == -1 ? count : Math.min(minGroup, count);
            return;
        } else if (sum > amount || (minGroup != -1 && count >= minGroup)) {
            return;
        }
        for (int coin : coins) {
            dfs(coins, sum + coin, count + 1);
        }
    }

}

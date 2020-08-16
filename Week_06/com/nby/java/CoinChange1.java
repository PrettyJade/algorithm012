import java.util.Arrays;

/**
 * @author nanbeiyang
 * @version CoinChange.java, v 0.1 2020/8/12 3:09 下午  Exp $$
 * @name
 */
public class CoinChange1 {
    int ans;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int i = 0, j = coins.length - 1;
        while (i < j) {
            int temp = coins[i];
            coins[i] = coins[j];
            coins[j] = temp;
            i ++; j --;
        }
        ans = amount + 1;
        coinChange(coins, amount,  0, 0);
        return ans == amount + 1 ? -1 : ans;
    }

    private void coinChange(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        if (index == coins.length) {
            return;
        }

        for (int k = amount / coins[index]; k >= 0 && k + count < ans; k --) {
            coinChange(coins, amount - k * coins[index], index + 1, count + k);
        }
    }
    public int minPathSum(int[][] grid) {
        int[] pd = new int[grid.length];
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if (j > 0) {
                    pd[j] = Math.min(pd[j], pd[j - 1]);
                }
                pd[j] += grid[i][j];
            }
        }
        return pd[grid.length - 1];
    }
}

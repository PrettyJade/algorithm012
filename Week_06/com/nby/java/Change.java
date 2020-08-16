/**
 * @author nanbeiyang
 * @version Change.java, v 0.1 2020/8/14 4:36 下午  Exp $$
 * @name
 */
public class Change {
    int count;
    public int change(int amount, int[] coins) {
        dfs(amount, coins);
        return count;
    }
    public void dfs(int amount, int[] coins) {
        if (amount == 0) {
            count ++;
            return;
        }
        if (amount < 0) {
            return;
        }
        for (int i = 0     ; i < coins.length; i ++) {
            dfs(amount - coins[i], coins);
        }
    }
}

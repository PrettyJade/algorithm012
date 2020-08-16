/**
 * @author nanbeiyang
 * @version MaxProfit3.java, v 0.1 2020/8/14 2:45 下午  Exp $$
 * @name
 */
public class MaxProfit3 {
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int k = 2;
        int[][][] pd = new int[prices.length][k + 1][2];
        for (int j = k; j > 0; j--) {
            pd[0][j][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                pd[i][j][0] = Math.max(pd[i - 1][j][0], pd[i - 1][j][1] + prices[i]);
                pd[i][j][1] = Math.max(pd[i - 1][j][1], pd[i - 1][j - 1][0] - prices[i]);
            }
        }
        return pd[n - 1][k][0];
    }

    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int i : prices) {
            release2 = Math.max(release2, hold2 + i);
            hold2 = Math.max(hold2, release1 - i);
            release1 = Math.max(release1, hold1 + i);
            hold1 = Math.max(hold1, -i);
        }
        return release2;
    }
}

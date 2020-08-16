/**
 * @author nanbeiyang
 * @version MaxProfit5.java, v 0.1 2020/8/14 3:54 下午  Exp $$
 * @name
 */
public class MaxProfit5 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if (k >= n >>> 1) {
            return maxProfit2(prices);
        }
        int[][] pd = new int[k + 1][n];
        for (int i = 1; i <= k; i ++) {
            int maxTemp = -prices[0];
            for (int j = 1; j < n; j ++) {
                pd[i][j] = Math.max(pd[i][j - 1], maxTemp + prices[j]);
                maxTemp = Math.max(maxTemp, pd[i - 1][j - 1] - prices[j]);
            }
        }
        return pd[k][n - 1];
    }
    public int maxProfit2(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            if (prices[i] < prices[i + 1]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
}

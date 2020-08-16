/**
 * @author nanbeiyang
 * @version MaxProfit6.java, v 0.1 2020/8/14 3:57 下午  Exp $$
 * @name
 */
public class MaxProfit6 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; i ++) {
            int temp = sell;
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, temp - prices[i]);
        }
        return sell;
    }
}

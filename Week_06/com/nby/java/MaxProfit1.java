/**
 * @author nanbeiyang
 * @version MaxProfit1.java, v 0.1 2020/8/14 2:01 下午  Exp $$
 * @name
 */
public class MaxProfit1 {
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int sell = 0;
        int buy = Integer.MIN_VALUE;

        for (int price : prices) {
            sell = Math.max(sell, buy + price);
            buy = Math.max(buy, -price);
        }
        return sell;
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int ans = 0;
        int bought = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (bought > prices[i]) {
                bought = prices[i];
            } else {
                if (prices[i] - bought > ans) {
                    ans = prices[i] - bought;
                }
            }
        }
        return ans;
    }
}

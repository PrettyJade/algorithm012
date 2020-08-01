/**
 * @author nanbeiyang
 * @version MaxProfit.java, v 0.1 2020/7/29 3:03 下午  Exp $$
 * @name
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            if (prices[i] < prices[i + 1]) {
                sum += prices[i + 1] - prices[i];
                i ++;
            }
        }
        return sum;
    }
}

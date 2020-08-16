/**
 * @author nanbeiyang
 * @version MaxProfit2.java, v 0.1 2020/8/14 2:10 下午  Exp $$
 * @name
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            if (prices[i] < prices[i + 1]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
}

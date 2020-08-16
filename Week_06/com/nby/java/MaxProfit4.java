/**
 * @author nanbeiyang
 * @version maxProfit4.java, v 0.1 2020/8/14 3:41 下午  Exp $$
 * @name
 */
public class MaxProfit4 {
    public int maxProfit(int[] prices) {
       int sell = 0, buy = Integer.MIN_VALUE, preSell = 0;
       for (int price : prices) {
           int temp = sell;
           sell = Math.max(sell, buy + price);
           buy = Math.max(buy, preSell - price);
           preSell = temp;
       }
       return sell;
    }
}

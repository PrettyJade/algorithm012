/**
 * @author nanbeiyang
 * @version MumSquares.java, v 0.1 2020/8/14 6:05 下午  Exp $$
 * @name
 */
public class MumSquares {
    /**
     * 这道题的一个简单子问题是dp[i] = min(dp[i - K] + 1，...) k：是平方数
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j ++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        MumSquares squares = new MumSquares();
        System.out.println(squares.numSquares(38494));

    }

}

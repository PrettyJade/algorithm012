/**
 * @author nanbeiyang
 * @version NumDistinct.java, v 0.1 2020/9/2 3:55 下午  Exp $$
 * @name
 */
public class NumDistinct {
    public int numDistinct(String s, String t) {
        // dp[i][j]  T 的第i个字符，在S到j里组成多少个
        // t.i = s.j  dp[i][j] += dp[i -  1][j - 1]
        int n = t.length(), m = s.length();
        int[][] dp = new int[n + 1][m + 1];
        // 初始化，模拟在s和，t左端都设置空字符串

        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
           dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i][j - 1];
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}

/**
 * @author nanbeiyang
 * @version LongestCommonSubsequence.java, v 0.1 2020/8/10 7:52 下午  Exp $$
 * @name
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (text2.charAt(i - 1) == text1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}

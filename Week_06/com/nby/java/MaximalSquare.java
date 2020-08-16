/**
 * @author nanbeiyang
 * @version MaximalSquare.java, v 0.1 2020/8/15 2:54 下午  Exp $$
 * @name
 */
public class MaximalSquare {
    // 通过动态规划求解
    // 一个点是否是正方形，有左，下，对角决定的所以就会有这个的子问题
    // dp[i, j] = min(dp[i - 1, j], dp[i, j - 1], dp[i + 1, j - 1] + 1
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return n;
        }
        int m = matrix[0].length, maxSide = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}

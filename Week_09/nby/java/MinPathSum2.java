/**
 * @author nanbeiyang
 * @version MinPathSum2.java, v 0.1 2020/9/2 12:26 下午  Exp $$
 * @name
 */
public class MinPathSum2 {
    public int minPathSum1(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        // dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != 0 && j != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i == 0 && j != 0){
                    dp[i][j] = dp[i][j - 1];
                } else if (i != 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                dp[i][j] += grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

}

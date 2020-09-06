/**
 * @author nanbeiyang
 * @version UniquePaths2.java, v 0.1 2020/9/2 12:46 下午  Exp $$
 * @name
 */
public class UniquePaths2 {

    public int uniquePaths(int m, int n) {
        // dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j ==0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i != 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                } else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (i != 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[0][0] = 1;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

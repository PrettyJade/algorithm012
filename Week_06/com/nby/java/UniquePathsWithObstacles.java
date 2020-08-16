/**
 * @author nanbeiyang
 * @version UniquePathsWithObstacles.java, v 0.1 2020/8/10 6:14 下午  Exp $$
 * @name
 */
public class UniquePathsWithObstacles {

    int m, n;
    int[][] obstacleGrid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;
        int[][] a = new int[m][n];
        dp(0, 0, a);
        return a[0][0];
    }

    private int dp(int x, int y, int[][] a) {
        if (x == m || y == n || obstacleGrid[x][y] == 1) {
            return 0;
        } else if (x == m - 1 && y == n - 1) {
            a[x][y] = 1;
        } else if (a[x][y] == 0) {
            a[x][y] = dp(x + 1, y, a) + dp(x, y + 1, a);
        }
        return a[x][y];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] a = new int[m][n];

        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            a[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            a[0][i] = 1;
        }
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                if (obstacleGrid[x][y] == 0) {
                    a[x][y] = a[x - 1][y] + a[x][y - 1];
                }
            }
        }
        return a[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] a = new int[n];
        a[0] = 1 - obstacleGrid[0][0];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (obstacleGrid[x][y] == 1) {
                    a[y] = 0;
                } else if (y - 1 >= 0 && obstacleGrid[x][y - 1] == 0) {
                    a[y] += a[y - 1];
                }
            }
        }
        return a[m - 1];
    }

}

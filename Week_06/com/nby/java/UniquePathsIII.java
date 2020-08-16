/**
 * @author nanbeiyang
 * @version UniquePathsIII.java, v 0.1 2020/8/14 9:46 下午  Exp $$
 * @name
 */
public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0, step = 1;
        // 首先确定起始位置，和需要走过的总步数
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (grid[i][j] == 0) {
                    step ++;
                }
            }
        }
        return dfs(startX, startY, step, grid);
    }

    private int dfs(int x, int y, int step, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return step == 0 ? 1 : 0;
        }
        grid[x][y] = -1;
        int res = 0;
        res += dfs(x + 1, y, step - 1, grid);
        res += dfs(x - 1, y, step - 1, grid);
        res += dfs(x, y - 1, step - 1, grid);
        res += dfs(x, y + 1, step - 1, grid);
        grid[x][y] = 0;
        return res;
    }
}


/**
 * @author nanbeiyang
 * @version NumIslands.java, v 0.1 2020/7/29 10:18 上午  Exp $$
 * @name
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[r].length; c ++) {
                if (grid[r][c] == '1') {
                    count ++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 ||c >= grid[r].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

}

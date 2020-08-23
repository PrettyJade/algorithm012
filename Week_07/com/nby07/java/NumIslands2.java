/**
 * @author nanbeiyang
 * @version NumIslands.java, v 0.1 2020/8/21 1:57 下午  Exp $$
 * @name
 */
public class NumIslands2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(grid);
        int[] row = {1, 0, -1, 0};
        int[] col = {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    grid[0][0] = '0';
                    for (int k = 0; k < row.length; k++) {
                        int i1 = i + row[k];
                        int j1 = j + col[k];
                        if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < m && grid[i1][j1] == '1') {
                            uf.union(i * m + j, i1 * m + j1);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(char[][] grid) {
            int n = grid.length, m = grid[0].length;
            parent = new int[n * m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        int index = i * m + j;
                        parent[index] = index;
                        count++;
                    }
                }
            }
        }

        public int findParent(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int parentX = findParent(x);
            int parentY = findParent(y);
            if (parentX != parentY) {
                parent[parentY] = parentX;
                count--;
            }
        }
    }

    public static void main(String[] args) {
        NumIslands2 islands2 = new NumIslands2();
        char[][] grid = {{'1'}, {'1'}};
        islands2.numIslands(grid);
    }
}

/**
 * @author nanbeiyang
 * @version findCircleNum.java, v 0.1 2020/8/20 6:11 下午  Exp $$
 * @name
 */
public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        // 方法1通过dsf
        // 确定一个访问数组,主要判断关系是否访问过
        boolean[] visited = new boolean[M.length];
        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                // 从i开始查找朋友圈关系
                dfs(visited, i, M);
                count++;
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int i, int[][] m) {
        for (int j = 0; j < m[i].length; j++) {
            // 查找第i层的朋友关系
            if (m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                // 若i和j有关系，就判断j和谁有关系，因为关系是传递
                dfs(visited, j, m);
            }
        }
    }
}

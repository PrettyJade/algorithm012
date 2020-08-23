/**
 * @author nanbeiyang
 * @version FindCircleNum1.java, v 0.1 2020/8/20 6:26 下午  Exp $$
 * @name
 */
public class FindCircleNum1 {
    int count;
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        count = M.length;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        return count;
    }

    public void union(int[] parent, int x, int y) {
        int parentX = parent(parent, x);
        int parentY = parent(parent, y);
        if (parentX != parentY) {
            parent[x] = parentY;
            count --;
        }
    }

    private int parent(int[] parent, int x) {
        while (parent[x] != x) {
            // 为了方便下次的查找效率
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

}

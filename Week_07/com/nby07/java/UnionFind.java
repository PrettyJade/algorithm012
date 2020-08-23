/**
 * @author nanbeiyang
 * @version UnionFind.java, v 0.1 2020/8/21 3:14 下午  Exp $$
 * @name
 */
public class UnionFind {
    int[] parent;
    int count;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[size] = size;
            count++;
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

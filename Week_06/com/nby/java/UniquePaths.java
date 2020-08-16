import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author nanbeiyang
 * @version UniquePaths.java, v 0.1 2020/8/8 9:54 下午  Exp $$
 * @name
 */
public class UniquePaths {
    int m, n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        int[][] a = new int[m][n];
        dp(0, 0, a);
        Deque<Integer> deque = new ArrayDeque();
        return a[0][0];
    }

    private int dp(int x, int y, int[][] a) {

        if (x == m - 1 || y == n - 1) {
            a[x][y] = 1;
            return a[x][y];
        }
        if (a[x][y] == 0) {
            a[x][y] = dp(x + 1, y, a) + dp(x, y + 1, a);
        }
        return a[x][y];
    }
}

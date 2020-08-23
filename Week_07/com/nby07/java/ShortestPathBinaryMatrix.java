import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author nanbeiyang
 * @version ShortestPathBinaryMatrix.java, v 0.1 2020/8/23 9:05 下午  Exp $$
 * @name
 */
public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix2(int[][] grid) {
        int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int count = 1;
        int n = grid.length, m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        Deque<int[]> pathDeque = new LinkedList<>();

        pathDeque.add(new int[]{0, 0});
        while (!pathDeque.isEmpty()) {
            int size = pathDeque.size();
            for (int i = 0; i < size; i++) {
                int[] path = pathDeque.pop();
                if (path[0] == n - 1 && path[1] == m - 1) {
                    return count;
                }
                for (int[] dir : dirs) {
                    int x = path[0] + dir[0];
                    int y = path[1] + dir[1];
                    if (x < 0 || x == n || y < 0 || y == m || grid[x][y] == 1) {
                        continue;
                    }
                    grid[x][y] = 1;
                    pathDeque.add(new int[]{x, y});
                }
            }
            count++;
        }
        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int count = 1;
        int n = grid.length, m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        grid[0][0] = 1;
        PriorityQueue<Integer> pathQueue = new PriorityQueue<>(Collections.reverseOrder());

        pathQueue.offer(0);
        while (!pathQueue.isEmpty()) {
            int path = pathQueue.poll();
            int p1 = path / m;
            int p2 = path % m;
            if (p1 == n - 1 && p2 == m - 1) {

                return grid[p1][p2];
            }
            for (int[] dir : dirs) {
                int x = p1 + dir[0];
                int y = p2 + dir[1];
                if (x < 0 || x == n || y < 0 || y == m || grid[x][y] > 0) {
                    continue;
                }
                grid[x][y] = grid[p1][p2] + 1;
                pathQueue.offer(x * m + y);
            }
        }
        return -1;
    }
}

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
        int n = grid.length, m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        PriorityQueue<Node> pathQueue = new PriorityQueue<>(Collections.reverseOrder());

        pathQueue.offer(new Node(0, 0, 1, 0));
        while (!pathQueue.isEmpty()) {
            Node node = pathQueue.poll();
            if (node.x == n - 1 && node.y == m - 1) {
                return node.path;
            }
            grid[node.x][node.y] = 1;
            pathQueue.removeIf((o) -> o.x == node.x && o.y == node.y);
            for (int[] dir : dirs) {
                int x = node.x + dir[0];
                int y = node.y + dir[1];
                if (x < 0 || x == n || y < 0 || y == m || grid[x][y] == 1) {
                    continue;
                }
                int path = node.path + 1;

                pathQueue.offer(new Node(x, y, path, path + Math.max(Math.abs(n - x - 1), Math.abs(m - y - 1))));
            }
        }
        return -1;
    }

}



class Node implements Comparable<Node> {
    int x;
    int y;
    int path;
    int priority;


    public Node(int x, int y, int path, int priority) {
        this.x = x;
        this.y = y;
        this.path = path;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", path=" + path +
                ", priority=" + priority +
                '}';
    }

    public boolean equals(Node o) {
        return this.x == o.x && this.y == o.y;
    }
    @Override
    public int compareTo(Node o) {
        return this.priority - o.priority;
    }
}

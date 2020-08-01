import java.util.HashSet;
import java.util.Set;

/**
 * @author nanbeiyang
 * @version RobotSim.java, v 0.1 2020/7/31 4:08 下午  Exp $$
 * @name
 */
public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int currX = 0, currY = 0, di = 0, ans = 0;
        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(((long)(obstacle[0] + 30000) << 16) + (long)(obstacle[1] + 30000));
        }
        for (int command : commands) {
            if (command == -1) {
                di = (di + 1) % 4;
            } else if (command == -2) {
                di = (di + 3) % 4;
            } else {
                for (int k = 0; k < command; k ++) {
                    int nx = currX + dx[di];
                    int ny = currY + dy[di];
                    if (!obstacleSet.contains(((long)(nx + 30000) << 16) + (long)(ny + 30000))) {
                        currX = nx;
                        currY = ny;
                        ans = Math.max(ans, currX * currX + currY * currY);
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }

}

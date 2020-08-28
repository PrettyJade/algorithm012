import java.util.Arrays;

/**
 * @author nanbeiyang
 * @version LeastInterval.java, v 0.1 2020/8/24 3:21 下午  Exp $$
 * @name
 */
public class LeastInterval {
    /**
     * 任务越多的越早安排它
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval1(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int count = 0;
            while (count <= n && count < 26 && map[25 - count] > 0) {
                map[25 - count]--;
                count++;
            }

            Arrays.sort(map);
            time += map[25] == 0 ? count : n + 1;
        }
        return time;
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        // 我们先计算出任务做的的任务A执行完后的空闲数是多少
        int maxVal = map[25] -1, idleSlots = maxVal * n;
        // 然后拿其他任务去填这个空槽,若是空槽被填满，那么，就等于任务总数了
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(maxVal, map[i]);
            if (idleSlots <= 0) {
                return tasks.length;
            }
        }
        // 不然等于任务总数 + 空槽数
        return tasks.length + idleSlots;
    }
}

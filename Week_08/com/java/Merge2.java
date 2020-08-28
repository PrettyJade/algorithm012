import java.util.Arrays;
import java.util.Comparator;

/**
 * @author nanbeiyang
 * @version Merge2.java, v 0.1 2020/8/27 9:15 下午  Exp $$
 * @name
 */
public class Merge2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int[][] res = new int[intervals.length][2];

        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(interval[1], res[idx][1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }


}

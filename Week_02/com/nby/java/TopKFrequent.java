import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author nanbeiyang
 * @version TopKFrequent.java, v 0.1 2020/7/19 2:21 下午  Exp $$
 * @name
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (int n : count.keySet()) {
            if (pq.size() < k) {
                pq.offer(n);
            } else if (count.get(pq.peek()) < count.get(n)) {
                pq.poll();
                pq.offer(n);
            }
        }

        int[] res = new int[k];
        int index = 0;
        for (int n : pq) {
            res[index ++] = n;
        }

        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : count.keySet()) {
            int frequency = count.get(n);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(n);
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && idx < k; i --) {
            if (bucket[i] != null) {
                for (int n : bucket[i]) {
                    res[idx ++] = n;
                }
            }
        }
        return res;
    }
}

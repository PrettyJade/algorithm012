import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author nanbeiyang
 * @version GetLeastNumbers.java, v 0.1 2020/7/18 6:42 下午  Exp $$
 * @name
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
       if (arr.length == 0 || k == 0) {
           return new int[0];
       } else if (arr.length == k){
           return arr;
       }

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i ++) {
            if (i < k) {
                pq.offer(arr[i]);
            } else if (arr[i] < pq.peek()) {
                pq.offer(arr[i]);
                pq.poll();
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (int p : pq) {
            res[idx ++] = p;
        }
        return res;
    }
}

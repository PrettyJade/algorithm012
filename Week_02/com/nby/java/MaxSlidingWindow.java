import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author nanbeiyang
 * @version MaxSlidingWindow.java, v 0.1 2020/7/18 9:48 下午  Exp $$
 * @name
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return nums;
        }
        //这道题可以通过双端队列来解决
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        // 初始化第一组k个值
        deque.addLast(0);
        for (int i = 1; i < nums.length; i ++) {
            // 移除非滑动窗口的元素索引
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            // 循环删除队列中小于当前元素的元素索引
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            // 当访问到第k个元素之后，都要将队列的首元素添加到结果集中
            if (i - k > -2) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}


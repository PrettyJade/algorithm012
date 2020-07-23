import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author nanbeiyang
 * @version Trap.java, v 0.1 2020/7/23 9:42 上午  Exp $$
 * @name
 */
public class Trap {
    /**
     * 暴力法
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int area = 0;
        for (int i = 1; i < height.length - 1; i ++) {
            int maxLeft = height[i];
            for (int l = i - 1; l > 0; l --) {
                maxLeft = Math.max(maxLeft, height[l]);
            }
            int maxRight = height[i];
            for (int r = i + 1; r > height.length; r ++) {
                maxRight = Math.max(maxRight, height[r]);
            }
            area += Math.min(maxLeft, maxRight) - height[i];
        }

        return area;
    }
    /**
     * 动态规划
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int area = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i ++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[size];
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i --) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i ++) {
            area += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return area;
    }
    /**
     * 单调栈
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int area = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < height.length; i ++) {
            while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                int top = deque.pop();
                if (deque.isEmpty()) {
                    break;
                }
                int distance = i - deque.peek()  - 1;
                area += (Math.min(height[i], height[deque.peek()]) - height[top]) * distance;
            }
            deque.push(i);
        }
        return area;
    }
    /**
     * 双指针法
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        int area = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    area += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }

                left ++;
            } else {
                if (height[right] < rightMax) {
                    area += rightMax- height[right];
                } else {
                    rightMax = height[right];
                }
                right --;
            }
        }
        return area;
    }

}

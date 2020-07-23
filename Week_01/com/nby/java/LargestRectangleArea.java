import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nanbeiyang
 * @version LargestRectangleArea.java, v 0.1 2020/7/22 8:25 下午  Exp $$
 * @name
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        // 暴力求解
        // 首先矩形的面积是底*高，
        // 这道题的底不长度不太容易确定
        // 所以我们通过遍历高度进行求解
        int maxArea = 0;

        for (int i = 0; i < heights.length; i ++) {
            int l = i;
            while (l > 0 && heights[l - 1] < heights[i]) {
                l --;
            }

            int r = i;
            while (r < heights.length - 1 && heights[r + 1] < heights[i]) {
                r ++;
            }
            maxArea = Math.max(maxArea, heights[i] * (r - l + 1));
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        // 单调栈的方式
        // 首先矩形的面积是底*高，
        // 这道题的底不长度不太容易确定
        // 所以我们通过遍历高度进行求解
        int maxArea = 0;
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        newHeights[newHeights.length - 1] = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);

        for (int i = 1; i < newHeights.length; i ++) {
            while (newHeights[deque.peek()] > newHeights[i]) {
                int curr = deque.pop();
                maxArea = Math.max(maxArea, heights[curr] * (i - deque.peek() + 1));
            }
            deque.push(i);
        }

        return maxArea;
    }
    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int max = 0;
        int[] stack = new int[n + 1];
        int is = -1;
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : heights[i];
            while (is != -1 && height < heights[stack[is]]) {
                int hh = heights[stack[is--]];
                int width = (is == -1) ? i : i - 1 - stack[is];
                max = Math.max(max, hh * width);
            }
            stack[++is] = i;
        }
        return max;


    }



    public static void main(String[] args) {
        LargestRectangleArea c = new LargestRectangleArea();
        int[] a = new int[]{2,1,5,6,2,3};
        System.out.println(c.largestRectangleArea2(a));
    }

}

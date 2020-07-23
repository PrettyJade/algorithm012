/**
 * @author nanbeiyang
 * @version MaxArea.java, v 0.1 2020/7/20 8:26 下午  Exp $$
 * @name
 */
public class MaxArea {
    public int maxArea(int[] height) {
        // 这道题的求解，维护两个指针，分别指向头和尾，求面积无非就是长*高，
        // 而这道题最长的长度已知，就是数组的长度，所以要想面积比最外围的大就需要高度比外围的高
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, area);
            // 判断两个垂直线那条短，就往里走一段，以获取更高的高度，依次来获得更大的面积

            if (height[i] < height[j]) {
                int o = i;
                i ++;
                while (height[o] > height[i] && i < j) {
                    i ++;
                }
            } else {
                int o = j;
                j --;
                while (height[o] > height[j] && i < j) {
                    j --;
                }
            }
        }
        return maxArea;
    }

}

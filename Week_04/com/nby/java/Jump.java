/**
 * @author nanbeiyang
 * @version Jump.java, v 0.1 2020/7/31 5:23 下午  Exp $$
 * @name
 */
public class Jump {
    public int jump(int[] nums) {
        int step = 0, maxPosition = 0, end = 0;
        for (int i = 0; i < nums.length; i ++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step ++;
            }
        }
        return step;
    }


}

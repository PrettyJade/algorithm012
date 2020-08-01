/**
 * @author nanbeiyang
 * @version CanJump.java, v 0.1 2020/7/31 5:09 下午  Exp $$
 * @name
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int i = nums.length - 1, j = i - 1;
        while (j >= 0) {
            if (nums[j] >= i - j) {
                i = j;
            }
            j --;
        }
        return i == 0;
    }

}

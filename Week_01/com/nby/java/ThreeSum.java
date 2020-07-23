import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nanbeiyang
 * @version ThreeSum.java, v 0.1 2020/7/20 9:59 下午  Exp $$
 * @name
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 2) {
            return res;
        }
        // 排序
        Arrays.sort(nums);

        for (int p1 = 0; p1 < nums.length - 2 && nums[p1] <= 0; p1++) {
            if (p1 > 0 && nums[p1] == nums[p1 - 1]) {
                continue;
            }
            int target = -nums[p1];
            int p2 = p1 + 1, p3 = nums.length - 1;
            while (p2 < p3) {
                if (target == nums[p2] + nums[p3]) {
                    res.add(Arrays.asList(p1, p2, p3));
                    while (nums[p2 + 1] == nums[p2] && p2 < p3) {
                        p2++;
                    }
                    while (nums[p3 + 1] == nums[p3] && p2 < p3) {
                        p3--;
                    }
                } else if (target > nums[p2] + nums[p3]) {
                    p2++;
                } else {
                    p3--;
                }
            }
        }
        return res;
    }

}

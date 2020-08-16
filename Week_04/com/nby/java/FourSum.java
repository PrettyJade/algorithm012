import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nanbeiyang
 * @version FourSum.java, v 0.1 2020/8/8 5:23 下午  Exp $$
 * @name
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        if (4 * nums[0] > target || 4 * max < target) {
            return res;
        }
        int z;
        for (int i = 0; i < nums.length - 3; i++) {
            z = nums[i];
            if (i > 0 && nums[i - 1] == z) {
                continue;
            }
            if (z + 3 * max < target) {
                continue;
            }
            if (4 * z > target) {
                break;
            }


            for (int j = i + 1; j < nums.length - 2; j++) {
                if (i + 1 != j && nums[j] == nums[j - 1]) {
                    continue;
                }
                int f = j + 1;
                int l = nums.length - 1;
                int sum = target - nums[i] - nums[j];
                while (f < l) {
                    int towSum = nums[f] + nums[l];
                    if (towSum == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[f], nums[l]));
                        while (f < l && nums[f] == nums[++f]) {}
                        while (f < l && nums[l] == nums[--l]) {}
                    } else if (towSum < sum) {
                        while (f < l && nums[f] == nums[++f]) {}
                    } else {
                        while (f < l && nums[l] == nums[--l]) {}
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,-2,-5,-4,-3,3,3,5};
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(a, -11));
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * @author nanbeiyang
 * @version MajorityElement.java, v 0.1 2020/7/26 10:56 下午  Exp $$
 * @name
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int k = nums.length / 2;
        for (Integer key : count.keySet()) {
            if (count.get(key) > k) {
                return key;
            }
        }
        return 0;
    }

}

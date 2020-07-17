import java.util.HashMap;
import java.util.Map;

/**
 * @author nanbeiyang
 * @version TwoSum.java, v 0.1 2020/7/16 7:50 下午  Exp $$
 * @name
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历当前数组
        for (int i = 0; i < nums.length ; i++) {
            // 获取到当前元素相对应到目标元素
            int complement = target - nums[i];
            // 判断是否在map中，存在返回对应下标
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            // 不存在存到数组里面，等到数组遍历到他的目标元素
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(4);


        map.put(7, 1);
        map.put(15, 1);
        map.put(31, 1);
    }

}

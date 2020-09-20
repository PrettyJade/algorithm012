import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author nanbeiyang
 * @version opKFrequent2.java, v 0.1 2020/9/7 9:02 下午  Exp $$
 * @name
 */
public class opKFrequent2 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> data = new HashMap<>();
        for (int num : nums) {
            data.put(num, data.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        data.forEach((key, value) -> {
            List<Integer> numList = bucket[value];
            if (numList == null) {
                numList = new ArrayList<>();
            }
            numList.add(key);
            bucket[value] = numList;
        });
        int[] ans = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            List<Integer> numList = bucket[i];
            if (numList != null) {
                for (int j = 0; j < numList.size() && index < k; j++) {
                    ans[index ++] = numList.get(j);
                }
            }

        }
        return ans;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version PermuteUnique.java, v 0.1 2020/7/26 9:50 下午  Exp $$
 * @name
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(res, new LinkedList<>(), used, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, LinkedList<Integer> curr, boolean[] used, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new LinkedList<>(curr));
        }
        for (int i = 0; i < nums.length; i ++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            curr.addLast(nums[i]);
            used[i] = true;

            dfs(res, curr, used, nums);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            curr.removeLast();
        }
    }

}

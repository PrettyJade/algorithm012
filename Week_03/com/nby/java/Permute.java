import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version Permute.java, v 0.1 2020/7/24 9:39 下午  Exp $$
 * @name
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(nums, new LinkedList<>(), res, used);
        return res;
    }

    private void dfs(int[] nums, LinkedList<Integer> curr, List<List<Integer>> res, boolean[] used) {
        if (curr.size() == nums.length) {
            res.add(new LinkedList<>(curr));
        }
        for (int i = 0; i < nums.length; i ++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);
            dfs(nums, curr, res, used);
            used[i] = false;
            curr.removeLast();
        }
    }


}

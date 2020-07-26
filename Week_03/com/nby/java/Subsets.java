import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version Subsets.java, v 0.1 2020/7/26 12:30 下午  Exp $$
 * @name
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i ++) {
            dfs(res, i, 0, nums, new LinkedList<>());
        }
        return res;
    }

    private void dfs(List<List<Integer>> res, int k, int level, int[] nums, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            res.add(new LinkedList<>(curr));
            return;
        }

        for (int i = level; i < nums.length; i ++) {
            curr.addLast(nums[i]);
            dfs(res, k, i + 1, nums, curr);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(new int[] {1,2,3});
    }


}

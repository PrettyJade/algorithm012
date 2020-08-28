import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author nanbeiyang
 * @version FindSubsequences.java, v 0.1 2020/8/25 12:07 上午  Exp $$
 * @name
 */
public class FindSubsequences {
    public List<List<Integer>> findSubsequences1(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(new LinkedList<>(), 0, nums, res);
        return res;
    }

    private void dfs(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res) {
        if (list.size() > 1) {
            res.add(new LinkedList<>(list));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            boolean conditions = (list.size() > 0 && list.getLast() > nums[i]) || used.contains(nums[i]);
            if (conditions) {
                continue;
            }
            used.add(nums[i]);
            list.add(nums[i]);
            dfs(list, i + 1, nums, res);
            list.removeLast();
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        LinkedList<Integer> temp = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        dfs1(ans, temp, 0, Integer.MIN_VALUE, nums);
        return ans;
    }
    public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
    private void dfs1(List<List<Integer>> ans, LinkedList<Integer> temp, int cur, int pre, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() > 1) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // 选择当前数
        if (nums[cur] >= pre) {
            temp.add(nums[cur]);
            dfs1(ans, temp, cur + 1, nums[cur], nums);
            temp.removeLast();
        }

        // 分支，不选择当前数, 如果当前数和上一个相等，直接剪枝
        if (nums[cur] != pre) {
            dfs1(ans, temp, cur + 1, pre, nums);
        }
    }

    public static void main(String[] args) {
        FindSubsequences s = new FindSubsequences();
        int[] nums = new int[]{4, 5, 7, 7, 4};
        System.out.println(s.findSubsequences(nums));
        s.reverseBits(14);
    }
    public int reverseBits(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum = sum << 1 + (n & 1);
            n >>= 1;
        }
        return sum;
    }

    public int[] countBits(int num) {
        // 可以用动态规划
        // dp[i] = dp[i & (i - 1)] + 1;
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

}

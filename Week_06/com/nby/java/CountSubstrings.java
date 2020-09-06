/**
 * @author nanbeiyang
 * @version CountSubstrings.java, v 0.1 2020/8/15 4:44 下午  Exp $$
 * @name
 */
public class CountSubstrings {
    // 这道题可以用dp来解决
    // dp[i][j] = d[i + 1][j - 1] && s[i] == s[j]
    public int countSubstrings1(String s) {
        int size = s.length();
        if (size == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[size][size];
        dp[0][0] = true;
        for (int i = 1; i < size; i++) {
            dp[i][i] = true;
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
            }
        }
        for (int len = 2; len < size; len++) {
            for (int i = 0; i < size - len; i++) {
                int j = i + len;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        int ans = 0;
        for (boolean[] a : dp) {
            for (boolean b : a) {
                if (b) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public int countSubstrings2(String s) {
        int count = 0, n = s.length() * 2 - 1;
        for (int i = 0; i < n; i++) {
            int l = i / 2;
            int r = l + i % 2;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }
        return count;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
            if (i == 0 && minLen == Integer.MAX_VALUE) {
                return 0;
            }
        }
        return minLen;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        // 滑动窗口解法
        if (nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                minLen = Math.min(minLen, end - start + 1);
                start++;
                sum -= nums[start];
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int minSubArrayLen(int s, int[] nums) {
        // 滑动窗口解法
        if (nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                minLen = Math.min(minLen, end - start + 1);
                start++;
                sum -= nums[start];
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int countSubstrings(String s) {
        StringBuilder builder = new StringBuilder("$#");
        for (char c : s.toCharArray()) {
            builder.append(c).append('#');
        }
        builder.append('!');
        int[] dp = new int[builder.length()];
        int maxI = 0, maxR = 0, ans = 0;
        for (int i = 1; i < builder.length() - 2; i++) {
            dp[i] = i <= maxR ? Math.min(dp[maxI * 2 - i], maxR - i + 1) : 1;
            while (builder.charAt(i + dp[i]) == builder.charAt(i - dp[i])) {
                dp[i]++;
            }

            if (i + dp[i] - 1 > maxR) {
                maxR = i + dp[i] - 1;
                maxI = i;
            }
            ans += dp[i] / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubstrings2 countSubstrings = new CountSubstrings2();
        countSubstrings.countSubstrings("babab");
    }
}

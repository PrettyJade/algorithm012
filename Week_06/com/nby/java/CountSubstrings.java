/**
 * @author nanbeiyang
 * @version CountSubstrings.java, v 0.1 2020/8/15 4:44 下午  Exp $$
 * @name
 */
public class CountSubstrings {
    // 这道题可以用dp来解决
    // dp[i][j] = d[i + 1][j - 1] && s[i] == s[j]
    public int countSubstrings(String s) {
        int size = s.length();
        if (size == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[size][size];
        dp[0][0] = true;
        for (int i = 1; i < size; i ++) {
            dp[i][i] = true;
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
            }
        }
        for (int len = 2; len < size; len ++) {
            for (int i = 0; i < size - len; i ++) {
                int j = i + len;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        int ans = 0;
        for (boolean[] a : dp) {
            for (boolean b : a) {
                if (b) {
                    ++ ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        countSubstrings.countSubstrings("babab");
    }
}

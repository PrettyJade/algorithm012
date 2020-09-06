/**
 * @author nanbeiyang
 * @version CountSubstrings.java, v 0.1 2020/9/5 7:39 下午  Exp $$
 * @name
 */
public class CountSubstrings2 {
    /**
     * 用动态规划的方式
     * dp[i][j] 这个表示s从i到j是都回文字传
     * dp[i][j] = i = j = dp[i -1][j - 1] + 2;
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int size = s.length();
        if (size == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[size][size];
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans ++;
                }
            }
        }

        return ans;
    }
}

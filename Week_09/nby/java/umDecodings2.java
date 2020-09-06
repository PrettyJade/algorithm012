/**
 * @author nanbeiyang
 * @version umDecodings2.java, v 0.1 2020/9/2 2:34 下午  Exp $$
 * @name
 */
public class umDecodings2 {
    public int numDecodings(String s) {
        // dp[i] = dp[i - 1] + 1 + ?
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[n];

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }

            int num = 10 * s.charAt(i - 1) + s.charAt(i);
            if (num >= 10 && num <= 26) {
                dp[i] += i == 1 ? 1 : dp[i - 2];
            }
            if (dp[i] == 0) {
                return 0;
            }
        }
        return dp[n - 1];
    }
}

/**
 * @author nanbeiyang
 * @version NumDecodings.java, v 0.1 2020/8/15 1:45 下午  Exp $$
 * @name
 */
public class NumDecodings {
    // 这道题，类似于斐波那契数列
    // 由此可以得出dp公式是 f(i) = f(i - 2) + f(i - 1)
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return n;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] pd = new int[n];
        pd[0] = 1;
        for (int i = 1; i < n; i ++) {
            if (s.charAt(i) != '0') {
                pd[i] = pd[i - 1];
            }
            int num = 10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0');
            if (num >= 10 && num <= 26) {
                pd[i] += i == 1 ? 1 : pd[i - 2];
            }
            if (pd[i] == 0) {
                return 0;
            }
        }
        return pd[n - 1];
    }
}

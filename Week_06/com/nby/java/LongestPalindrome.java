/**
 * @author nanbeiyang
 * @version LongestPalindrome.java, v 0.1 2020/8/17 8:25 下午  Exp $$
 * @name
 */
public class LongestPalindrome {
    // 一个回文字串的定义是从中心点开始，两边是一样的
    // 所有我们通过遍历数组，确定中心点，向两边扩散
    // 而中心点有两种方式，一种是一个字符，一种是两个字符
    public String longestPalindrome(String s) {
        int pos = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i ++) {
            // 一个字符为中心点
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l --;
                r ++;
            }
            if (r - l - 1 > maxLen) {
                pos = l + 1;
                maxLen = r - l - 1;
            }

            // 以i 和i+ 1为中心点，向两边扩散
            l = i; r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l --;
                r ++;
            }
            if (r - l - 1 > maxLen) {
                pos = l + 1;
                maxLen = r - l - 1;
            }

        }
        return s.substring(pos, pos + maxLen);
    }

}

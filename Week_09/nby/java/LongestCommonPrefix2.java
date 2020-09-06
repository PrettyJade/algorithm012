/**
 * @author nanbeiyang
 * @version LongestCommonPrefix2.java, v 0.1 2020/9/5 3:30 下午  Exp $$
 * @name
 */
public class LongestCommonPrefix2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int index = 0;
        int maxLen = strs[0].length();
        while (true) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= index || strs[i].charAt(index) != strs[0].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
            if (maxLen == (++ index)) {
                return strs[0];
            }
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix2 prefix2 = new LongestCommonPrefix2();
        String[] a = {"flower","flow","flight"};
        System.out.println(prefix2.longestCommonPrefix(a));
    }

}

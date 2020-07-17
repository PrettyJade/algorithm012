import java.util.Arrays;

/**
 * @author nanbeiyang
 * @version IsAnagram.java, v 0.1 2020/7/16 4:41 下午  Exp $$
 * @name
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        // 判断字符数不想等直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        // 初始化一个26字母哈希表，保存格字母出现的次数
        int[] alpha = new int[26];
        // 遍历字符串s和t
        // s负责+1，t负责-1
        for (int i = 0; i < s.length(); i ++) {
            alpha[s.charAt(i) - 97] ++;
            alpha[t.charAt(i) - 97] --;
        }
        // 如果哈希表的值都为 0，则二者是字母异位词
        for (int num : alpha) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        // 判断字符数不想等直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }
}

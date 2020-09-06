/**
 * @author nanbeiyang
 * @version FirstUniqChar.java, v 0.1 2020/9/5 1:50 下午  Exp $$
 * @name
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 97]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i) - 97] == 1) {
                return i;
            }

        }
        return 0;
    }
}

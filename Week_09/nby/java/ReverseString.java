/**
 * @author nanbeiyang
 * @version ReverseString.java, v 0.1 2020/9/5 4:21 下午  Exp $$
 * @name
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i ++] = s[j];
            s[j --] = temp;
        }
    }
}

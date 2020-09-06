/**
 * @author nanbeiyang
 * @version ReverseStr.java, v 0.1 2020/9/5 4:35 下午  Exp $$
 * @name
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        if (k == 1 ||  s.length() == 0) {
            return s;
        }
        int k2 = k * 2;
        int index = 0;
        while (index < s.length()) {
            int j = index, f = Math.min(index + k, charArray.length) - 1;
            while (j < f) {
                char temp = charArray[j];
                charArray[j ++] = charArray[f];
                charArray[f --] = temp;
            }
            index += k2;
        }
        return String.valueOf(charArray);
    }
}

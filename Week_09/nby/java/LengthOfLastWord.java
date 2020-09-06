/**
 * @author nanbeiyang
 * @version LengthOfLastWord.java, v 0.1 2020/9/5 1:39 下午  Exp $$
 * @name
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count != 0) {
                    return count;
                }
            } else {
                count ++;
            }
        }
        return count;
    }
}

/**
 * @author nanbeiyang
 * @version ReverseWords2.java, v 0.1 2020/9/5 5:25 下午  Exp $$
 * @name
 */
public class ReverseWords2 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                ans.append(new StringBuffer(word).reverse());
                ans.append(' ');
            }
        }
        if (ans.length() > 0) {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }
}

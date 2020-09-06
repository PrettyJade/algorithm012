import java.util.Arrays;
import java.util.Collections;

/**
 * @author nanbeiyang
 * @version ReverseWords.java, v 0.1 2020/9/5 4:48 下午  Exp $$
 * @name
 */
public class ReverseWords {
    public String reverseWords2(String s) {
        String[] strArray = s.trim().split(" ");
        Collections.reverse(Arrays.asList(strArray));
        return String.join(" ", strArray);
    }


    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int k = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && k > 0) {
                for (int j = i + 1; j < i + k; j ++) {
                    builder.append(s.charAt(j));
                }
                builder.append(' ');
                k = 0;
            } else if (s.charAt(i) != ' ') {
                k++;
            }
        }
        if (k > 0) {
            builder.append(s, 0, k);
        } else if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ReverseWords words = new ReverseWords();
        words.reverseWords("a good   example");
    }

}

/**
 * @author nanbeiyang
 * @version ToLowerCase.java, v 0.1 2020/9/5 1:33 下午  Exp $$
 * @name
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        StringBuilder newStr = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                newStr.append((char)(c + 32));
            } else {
                newStr.append(c);
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        System.out.println((char)( 'A' + 32));
        System.out.println((int)'a');
    }
}

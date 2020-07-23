import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author nanbeiyang
 * @version IsValid.java, v 0.1 2020/7/22 5:03 下午  Exp $$
 * @name
 */
public class IsValid {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length % 2 == 1) {
            return false;
        }

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : charArray) {
            if (c == '(') {
                deque.push(')');
            } else if (c == '[') {
                deque.push(']');
            } else if (c == '{') {
                deque.push('}');
            } else if (deque.isEmpty() || c != deque.pop()) {
                return false;
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("){"));
    }

}

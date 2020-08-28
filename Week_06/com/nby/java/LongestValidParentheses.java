import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nanbeiyang
 * @version LongestValidParentheses.java, v 0.1 2020/8/24 4:33 下午  Exp $$
 * @name
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // 方法三通过栈的方式，维护一个栈，栈低元素始终是最后一个没有被匹配的右括号的下标
        // 而其他元素都是左括号的下标
        // 遇到没有个左括号，我们把它入栈，遇到右括号，我们出栈，判断栈是否为空
        // 不为空，表示有一个对应的左括号，那现有下标，减去栈顶的下标就是现有最长的有效括号的长度
        // 为空的话，表示没有对应的左括号，将当前压入栈
        Deque<Integer> deque = new LinkedList<>();
        deque.push(-1);
        int maxAns = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.push(i);
            } else {
                deque.pop();
                if (deque.isEmpty()) {
                    deque.push(i);
                } else {
                    maxAns = Math.max(maxAns, i - deque.peek());
                }
            }
        }
        return maxAns;
    }



    public static void main(String[] args) {
        LongestValidParentheses p = new LongestValidParentheses();
        System.out.println(p.longestValidParentheses(")()()"));
    }
}

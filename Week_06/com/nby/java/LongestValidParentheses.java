import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nanbeiyang
 * @version LongestValidParentheses.java, v 0.1 2020/8/24 4:33 下午  Exp $$
 * @name
 */
public class LongestValidParentheses {
    public int longestValidParentheses1(String s) {
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

    /**
     * 动态规划，存储中间状态为dp[i] 为第i为字符结尾的最长有效括号的长度
     * 因为有效括号是以）为结尾的，而以（的结尾的字符串的dp值必定是0，所以只要求解）在dp数组中对应的值
     * 我们从前往后进行检查，发现有两种情况会生成有效括号
     * 1 s[i] = ')' and s[i - 1] = '(' 也就是字符 （），我们可以推出
     *       dp[i] = dp[i - 2] + 2;
     * 2 s[i] = ')' and s[i - 1] = ')' 也就是字符串)) 我们可以推出如果s[i - dp[i - 1] - 1] = '('的话
     *       dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int maxAns = 0;
        s = ")" + s;
        int[] dp = new int[s.length() + 1];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else {
                    if (s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    }
                }
                maxAns = Math.max(maxAns, dp[i]);
            }

        }
        return maxAns;
    }

    /**
     * 我们利用两个计数器left 和right，我们从左往➡遍历，遇到（，left + 1， 遇到）right + 1
     * 每当left = right 的时候，我们当前有效括号的长度
     * 当right > left的 时候，重新至为0
     *
     * 但是这样有有一种情况无法求出有效括号，就是左括号永远大于右括号，(()，应对这种情况，需要从右往左进行比遍历
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxAns = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left ++;
            } else {
                right ++;
            }
            if (left == right) {
                maxAns = Math.max(maxAns, left * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left ++;
            } else {
                right ++;
            }
            if (left == right) {
                maxAns = Math.max(maxAns, left * 2);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxAns;
    }


    public static void main(String[] args) {
        LongestValidParentheses p = new LongestValidParentheses();
        System.out.println(p.longestValidParentheses(")()()"));
    }
}

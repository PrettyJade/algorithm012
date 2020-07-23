import java.util.LinkedList;

/**
 * @author nanbeiyang
 * @version MinStack.java, v 0.1 2020/7/22 5:56 下午  Exp $$
 * @name
 */
public class MinStack {

    private LinkedList<Integer> min_stack;

    private LinkedList<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        min_stack = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min_stack.isEmpty() || x <= min_stack.peek()) {
            min_stack.push(x);
        }
    }

    public void pop() {
        Integer x = stack.pop();
        if (x.equals(min_stack.peek())) {
            min_stack.pop();
        }
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}

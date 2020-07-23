/**
 * @author nanbeiyang
 * @version MinStack2.java, v 0.1 2020/7/22 7:50 下午  Exp $$
 * @name
 */
public class MinStack2 {
    private Node head;

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.minVal), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minVal;
    }

    class Node {
        int val;
        int minVal;
        Node next;
        public Node(int val, int minVal, Node next) {
            this.val = val;
            this.minVal = minVal;
            this.next = next;
        }
    }
}

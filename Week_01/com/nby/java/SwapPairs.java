/**
 * @author nanbeiyang
 * @version SwapPairs.java, v 0.1 2020/7/21 1:21 下午  Exp $$
 * @name
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(head.next);
        temp.next = head;

        return head;
    }
    class ListNode {
        int value;
        ListNode next;
        ListNode(int x) {
            value = x;
        }
    }
}


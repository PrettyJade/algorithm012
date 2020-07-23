/**
 * @author nanbeiyang
 * @version DetectCycle.java, v 0.1 2020/7/21 7:17 下午  Exp $$
 * @name
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow  = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
    class ListNode {
        int value;
        ListNode next;
        ListNode(int x) {
            value = x;
        }
    }

}

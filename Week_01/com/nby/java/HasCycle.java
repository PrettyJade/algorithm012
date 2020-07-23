/**
 * @author nanbeiyang
 * @version HasCycle.java, v 0.1 2020/7/21 2:30 下午  Exp $$
 * @name
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 这道题可以用双指针的方式
        // 创建一快一慢两个指针
        // 其中快指针走两步，慢指针走一步，如果是环形，快指针肯定能够追上慢指针
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            // 这里判断如果不是环形，直接返回false
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    class ListNode {
        int value;
        ListNode next;
        ListNode(int x) {
            value = x;
        }
    }

}

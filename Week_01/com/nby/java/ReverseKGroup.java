/**
 * @author nanbeiyang
 * @version ReverseKGroup.java, v 0.1 2020/7/21 7:53 下午  Exp $$
 * @name
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count ++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (head != null) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        return pre;
    }

    class ListNode {
        int value;
        ListNode next;
        ListNode(int x) {
            value = x;
        }
    }
}

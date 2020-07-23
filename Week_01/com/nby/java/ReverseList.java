/**
 * @author nanbeiyang
 * @version ReverseList.java, v 0.1 2020/7/20 10:39 下午  Exp $$
 * @name
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode suffix = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = suffix;
            suffix = cur;
            cur = temp;
        }
        return suffix;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

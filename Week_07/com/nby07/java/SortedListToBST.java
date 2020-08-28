import java.util.List;

/**
 * @author nanbeiyang
 * @version SortedListToBST.java, v 0.1 2020/8/24 10:53 下午  Exp $$
 * @name
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast.next != tail && fast.next.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = toBST(head, slow);
        node.right = toBST(slow.next, tail);
        return node;
    }

    private TreeNode dfs(int left, int right,  List<ListNode> array) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(array.get(mid).val);
        node.left = dfs(left, mid - 1, array);
        node.right = dfs(mid + 1, right, array);
        return node;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

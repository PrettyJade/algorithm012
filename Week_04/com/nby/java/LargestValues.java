import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version LargestValues.java, v 0.1 2020/7/28 11:38 上午  Exp $$
 * @name
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Integer max = null;
            while (size -- > 0) {
                TreeNode node = deque.poll();
                max = max == null ? node.val : Math.max(max, node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author nanbeiyang
 * @version PreorderTraversal.java, v 0.1 2020/7/17 3:12 下午  Exp $$
 * @name
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preOrder(root, res);
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            res.add(node.val);
            if (root.right != null) {
                deque.push(root.right);
            }
            if (root.left != null) {
                deque.push(root.left);
            }
        }
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        res.add(root.val);
        if (root.left != null) {
            preOrder(root.left, res);
        }
        if (root.right != null) {
            preOrder(root.right, res);
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    
    


}

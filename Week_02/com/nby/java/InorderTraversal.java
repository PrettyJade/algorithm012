import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author nanbeiyang
 * @version InorderTraversal.java, v 0.1 2020/7/17 2:34 下午  Exp $$
 * @name
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            preOrder(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            preOrder(root.right, res);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
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

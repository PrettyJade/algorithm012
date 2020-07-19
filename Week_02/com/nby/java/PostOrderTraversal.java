import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version PostOrderTraversal.java, v 0.1 2020/7/17 7:21 下午  Exp $$
 * @name
 */
public class PostOrderTraversal {
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public List<Integer> postOrderTraversal2(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        LinkedList<Integer> res = new LinkedList<>();
        TreeNode p = root;
        while (!deque.isEmpty() || p != null) {
            if (p != null) {
                deque.push(p);
                res.addFirst(p.val);
                p = p.right;
            } else {
                p = deque.pop();
                p = p.left;
            }
        }
        return res;
    }

    public List<Integer> postOrderTraversal3(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            res.addFirst(node.val);
            if (node.left != null) {
                deque.push(node.left);
            }
            if (node.right != null) {
                deque.push(node.right);
            }
        }
        return res;
    }


    public void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
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

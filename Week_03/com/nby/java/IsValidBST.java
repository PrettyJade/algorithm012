import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nanbeiyang
 * @version IsValidBST.java, v 0.1 2020/7/24 3:04 下午  Exp $$
 * @name
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        // 终止递归的判断，当遍历到叶子左右节点
        if (root == null) {
            return true;
        }
        // 获取当前节点的值
        Integer val = root.val;
        // 并比较当前节点，大于最小边界，小于最大边界
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        // 然后在遍历当前节点的左子树，当前节点将成为最大边界
        // 然后在遍历当前节点的右子树，当前节点将成为最小边界
        return helper(root.left, lower, val) && helper(root.right, val, upper);
    }
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer inorder = null;

        Deque<TreeNode> deque = new LinkedList<>();
        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            int val = root.val;
            if (inorder != null && val <= inorder) return false;
            inorder = val;
            root = root.right;
        }
        return true;
     }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

/**
 * @author nanbeiyang
 * @version MaxDepth.java, v 0.1 2020/7/24 3:39 下午  Exp $$
 * @name
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth  = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

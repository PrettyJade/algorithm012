/**
 * @author nanbeiyang
 * @version MaxDepth.java, v 0.1 2020/7/24 3:39 下午  Exp $$
 * @name
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right  + 1 : Math.min(left, right) + 1;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

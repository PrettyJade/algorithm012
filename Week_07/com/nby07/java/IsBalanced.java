/**
 * @author nanbeiyang
 * @version IBalanced.java, v 0.1 2020/8/17 6:01 下午  Exp $$
 * @name
 */
public class IsBalanced {
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSize = dfs(root.left);
        int rightSize = dfs(root.right);
        if (Math.abs(leftSize - rightSize) > 1) {
            ans = false;
        }
        return Math.max(leftSize, rightSize) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public static void main(String[] args) {
//        IsBalanced isBalanced = new IsBalanced();
//        isBalanced.isBalanced()
//    }
}

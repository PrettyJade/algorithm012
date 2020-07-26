import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nanbeiyang
 * @version BuildTree.java, v 0.1 2020/7/24 8:58 下午  Exp $$
 * @name
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i ++) {
            TreeNode node = deque.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorder[i]);
                deque.push(node.left);
            } else {
                while (!deque.isEmpty() && deque.peek().val == inorder[inorderIndex]) {
                    node = deque.pop();
                    inorderIndex ++;
                }
                node.right = new TreeNode(preorder[i]);
                deque.push(node.right);

            }
        }
        return root;
    }
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, Integer preIndex, int[] inorder, Integer inStart, int inEnd) {
        if (preIndex == preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIndex]);
        int inIndex = 0;
        // 查询到当前节点在中序中的位置
        for (int i = inStart; i <= inEnd; i ++) {
            if (inorder[i] == node.val) {
                inIndex = i;
            }
        }
        node.left = helper(preorder, preIndex + 1, inorder, inStart, inIndex - 1);
        node.right = helper(preorder, preIndex + inIndex - inStart + 1, inorder, inIndex + 1, inEnd);
        return node;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

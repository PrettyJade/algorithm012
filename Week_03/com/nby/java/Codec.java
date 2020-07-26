import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nanbeiyang
 * @version Codec.java, v 0.1 2020/7/24 5:26 下午  Exp $$
 * @name
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        String res = root.val + ",";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strList = data.split(",");
        if (strList.length == 0) {
            return null;
        }
        Deque<String> deque = new LinkedList<>(Arrays.asList(strList));
        return deserialize(deque);
    }

    private TreeNode deserialize(Deque<String> deque) {
        if (deque.isEmpty()) {
            return null;
        }
        String val = deque.remove();
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(deque);
        node.right = deserialize(deque);
        return node;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String s = "1,2,null,null,3,4,null,null,5,null,null";
        TreeNode node = codec.deserialize(s);
        System.out.println(node);
    }
}

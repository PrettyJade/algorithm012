import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version LevelOrder.java, v 0.1 2020/7/19 6:57 下午  Exp $$
 * @name
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (Node node : queue) {
                
            }
            for (int i = 0; i < size; i ++) {
                Node node = queue.pop();
                level.add(node.val);
                for (Node child : node.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

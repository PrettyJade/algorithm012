import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version Postorder.java, v 0.1 2020/7/19 6:19 下午  Exp $$
 * @name
 */
public class Postorder {

    public List<Integer> postorder(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        LinkedList<Integer> res = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
           Node node = deque.pop();
           res.addFirst(node.val);
           if (node.children != null && node.children.size() > 1) {
               for (Node child : node.children) {
                   deque.push(child);
               }
           }
        }
        return res;
    }
    public List<Integer> postorder2(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        deque.push(root);
        while (!deque.isEmpty()) {
            Node node = deque.pop();
            res.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                for (int i = node.children.size(); i <= 0; i --) {
                    deque.push(node.children.get(i));
                }
            }
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
    }

}

import java.util.HashMap;

/**
 * @author nanbeiyang
 * @version LRUCache1.java, v 0.1 2020/7/30 2:29 下午  Exp $$
 * @name
 */
public class LRUCache1 {
    class LinkedNode {
        int key;
        int value;
        LinkedNode after;
        LinkedNode before;

        public LinkedNode(int key, int value, LinkedNode after, LinkedNode before) {
            this.key = key;
            this.value = value;
            this.after = after;
            this.before = before;
        }
    }
    HashMap<Integer, LinkedNode> cache;
    LinkedNode first;
    LinkedNode last;
    int capacity;

    public LRUCache1(int capacity) {
        cache = new HashMap<>((int)(capacity / 0.75 + 1));
        this.capacity = capacity;
        first = new LinkedNode(-1, -1, null, null);
        last = new LinkedNode(-1, -1, null, null);
        first.after = last;
        last.before = first;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            putLast(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            LinkedNode node = cache.get(key);
            node.value = value;
            putLast(node);
        } else {
            if (cache.size() == capacity) {
                LinkedNode node = removeFirst();
                cache.remove(node.key);
            }
            LinkedNode node = new LinkedNode(key, value, null, null);
            putLast(node);
            cache.put(key, node);
        }
    }

    private LinkedNode removeFirst() {
        LinkedNode node = first.after;
        first.after = node.after;
        node.after.before = first;
        node.after = null;
        node.before = null;
        return node;
    }

    private void putLast(LinkedNode node) {
        if (node.after != null && node.before != null) {
            LinkedNode p = node.before;
            p.after = node.after;
            node.after.before = p;
        }
        LinkedNode p = last.before;
        p.after = node;
        node.before = p;
        node.after = last;
        last.before = node;
    }

}

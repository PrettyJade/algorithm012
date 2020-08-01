import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author nanbeiyang
 * @version LRUCache.java, v 0.1 2020/7/30 1:53 下午  Exp $$
 * @name
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}

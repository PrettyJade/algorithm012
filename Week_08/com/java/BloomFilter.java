import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author nanbeiyang
 * @version BloomFilter.java, v 0.1 2020/8/26 11:35 上午  Exp $$
 * @name
 */
public class BloomFilter implements Cloneable {
    private BitSet hashes;
    private RandomInRange prng;
    private int k; // Number of hash functions
    private static final double LN2 = 0.6931471805599453; // ln(2)

    /**
     * Create a new bloom filter.
     *
     * @param n Expected number of elements
     * @param m Desired size of the container in bits
     **/
    public BloomFilter(int n, int m) {
        k = (int) Math.round(LN2 * m / n);
        if (k <= 0) {
            k = 1;
        }
        this.hashes = new BitSet(m);
        this.prng = new RandomInRange(m, k);
    }

    /**
     * Create a bloom filter of 1Mib.
     *
     * @param n Expected number of elements
     **/
    public BloomFilter(int n) {
        this(n, 1024 * 1024 * 8);
    }

    /**
     * Add an element to the container
     **/
    public void add(Object o) {
        prng.init(o);
        for (RandomInRange r : prng) {
            hashes.set(r.value);
        }
    }

    /**
     * If the element is in the container, returns true.
     * If the element is not in the container, returns true with a probability ≈ e^(-ln(2)² * m/n), otherwise false.
     * So, when m is large enough, the return value can be interpreted as:
     * - true  : the element is probably in the container
     * - false : the element is definitely not in the container
     **/
    public boolean contains(Object o) {
        prng.init(o);
        for (RandomInRange r : prng) {
            if (!hashes.get(r.value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes all of the elements from this filter.
     **/
    public void clear() {
        hashes.clear();
    }

    /**
     * Create a copy of the current filter
     **/
    @Override
    public BloomFilter clone() throws CloneNotSupportedException {
        return (BloomFilter) super.clone();
    }

    /**
     * Generate a unique hash representing the filter
     **/
    @Override
    public int hashCode() {
        return hashes.hashCode() ^ k;
    }

    /**
     * Test if the filters have equal bitsets.
     * WARNING: two filters may contain the same elements, but not be equal
     * (if the filters have different size for example).
     */
    public boolean equals(BloomFilter other) {
        return this.hashes.equals(other.hashes) && this.k == other.k;
    }

    /**
     * Merge another bloom filter into the current one.
     * After this operation, the current bloom filter contains all elements in
     * other.
     **/
    public void merge(BloomFilter other) {
        if (other.k != this.k || other.hashes.size() != this.hashes.size()) {
            throw new IllegalArgumentException("Incompatible bloom filters");
        }
        this.hashes.or(other.hashes);
    }

    private class RandomInRange
            implements Iterable<RandomInRange>, Iterator<RandomInRange> {

        private Random prng;
        private int max; // Maximum value returned + 1
        private int count; // Number of random elements to generate
        private int i = 0; // Number of elements generated
        public int value; // The current value

        RandomInRange(int maximum, int k) {
            max = maximum;
            count = k;
            prng = new Random();
        }

        public void init(Object o) {
            prng.setSeed(o.hashCode());
        }

        @Override
        public Iterator<RandomInRange> iterator() {
            i = 0;
            return this;
        }

        @Override
        public RandomInRange next() {
            i++;
            value = prng.nextInt() % max;
            if (value < 0) {
                value = -value;
            }
            return this;
        }

        @Override
        public boolean hasNext() {
            return i < count;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        BloomFilter filter = new BloomFilter(2, 8);
        filter.add(3);
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(false);

    }

    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;
        dfs(0, mapping, digits, ans, new StringBuilder());
        return ans;
    }

    private void dfs(int index, String[] mapping, String digits, List<String> ans, StringBuilder builder) {
        if (index == digits.length()) {
            ans.add(builder.toString());
            return;
        }
        for (char c : mapping[digits.charAt(index) - 48].toCharArray()) {
            builder.append(c);
            dfs(index + 1, mapping, digits, ans, builder);
            builder.deleteCharAt(index);
        }
    }
}

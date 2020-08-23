/**
 * @author nanbeiyang
 * @version Trie.java, v 0.1 2020/8/20 1:57 下午  Exp $$
 * @name
 */
public class Trie {
    public TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.set(word.charAt(i));
        }
        node.setEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.getEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.get(word.charAt(i));
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;
        public TrieNode() {
            links = new TrieNode[26];
        }

        public TrieNode set(char ch) {
            TrieNode node = links[ch - 'a'];
            if (node == null) {
                node = new TrieNode();
                links[ch - 'a'] = node;
            }
            return node;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public Boolean containKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public boolean getEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}

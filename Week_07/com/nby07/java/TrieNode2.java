/**
 * @author nanbeiyang
 * @version TrieNode.java, v 0.1 2020/8/20 2:15 下午  Exp $$
 * @name
 */
public class TrieNode2 {
    private TrieNode2[] links;
    private boolean isEnd;
    public TrieNode2() {
        links = new TrieNode2[26];
    }

    public TrieNode2 set(char ch) {
        TrieNode2 node = links[ch - 'a'];
        if (node == null) {
            node = new TrieNode2();
            links[ch - 'a'] = node;
        }
        return node;
    }

    public TrieNode2 get(char ch) {
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

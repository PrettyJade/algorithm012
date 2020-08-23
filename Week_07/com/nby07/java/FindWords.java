import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version FindWords.java, v 0.1 2020/8/20 3:36 下午  Exp $$
 * @name
 */
public class FindWords {

    public List<String> findWords(char[][] board, String[] words) {
        // 第一步:将单词array插入到字典树中
        TrieNode root = setWordToTrie(words);
        // 通过dfs遍历整个board查找单词
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(root, i, j, board, ans);

            }
        }
        return ans;
    }

    private void dfs(TrieNode root, int i, int j, char[][] board, List<String> ans) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '#') {
            return;
        }
        char letter = board[i][j];
        TrieNode node = root.get(letter);
        if (node == null) {
            return;
        }
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        dfs(node, i + 1, j, board, ans);
        dfs(node, i - 1, j, board, ans);
        dfs(node, i, j + 1, board, ans);
        dfs(node, i, j - 1, board, ans);
        board[i][j] = letter;
    }


    private TrieNode setWordToTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode.insert(root, word);
        }
        return root;
    }

    static class TrieNode {
        private TrieNode[] links;
        private String word;

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


        public static void insert(TrieNode root, String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                node = node.set(word.charAt(i));
            }
            node.word = word;
        }
    }
}

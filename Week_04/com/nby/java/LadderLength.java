import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author nanbeiyang
 * @version LadderLength.java, v 0.1 2020/7/28 11:48 上午  Exp $$
 * @name
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> deque = new LinkedList<>();
        deque.offer(beginWord);
        int count = 0;
        HashSet<String> wordListLibrary = new HashSet<>(wordList);

        Set<String> visited = new HashSet<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String poll = deque.poll();
                if (poll.equals(endWord)) {
                    return count;
                }
                char[] curr = poll.toCharArray();
                for (int i = 0; i < poll.length(); i++) {
                    char old = poll.charAt(i);
                    for (char b = 'a'; b <= 'z'; b ++) {
                        if (old == b) {
                            continue;
                        }
                        curr[i] = b;
                        String newStr = new String(curr);
                        if (!visited.contains(newStr) && wordListLibrary.contains(newStr)) {
                            deque.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                    curr[i] = old;
                }
            }
            count++;
        }
        return 0;
    }

}

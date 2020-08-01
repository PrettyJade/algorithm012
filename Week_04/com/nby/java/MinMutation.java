import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author nanbeiyang
 * @version MinMutation.java, v 0.1 2020/7/28 10:30 上午  Exp $$
 * @name
 */
public class MinMutation {
    public int minMutation(String start, String end, String[] bank) {
        Deque<String> deque = new LinkedList<>();
        deque.offer(start);
        int count = 0;
        HashSet<String> bankLibrary = new HashSet<>(Arrays.asList(bank));
        char[] banks = {'A', 'C', 'G', 'T'};

        Set<String> visited = new HashSet<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String poll = deque.poll();
                if (poll.equals(end)) {
                    return count;
                }
                char[] curr = poll.toCharArray();
                for (int i = 0; i < poll.length(); i++) {
                    char old = poll.charAt(i);
                    for (char b : banks) {
                        curr[i] = b;
                        String newStr = new String(curr);
                        if (!visited.contains(newStr) && bankLibrary.contains(newStr)) {
                            deque.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                    curr[i] = old;
                }
            }
            count++;
        }
        return -1;
    }
    HashSet<String> bankLibrary;
    char[] banks;
    Set<String> visited ;
    String end;
    public int minMutation2(String start, String end, String[] bank) {
        bankLibrary = new HashSet<>(Arrays.asList(bank));
        banks = new char[]{'A', 'C', 'G', 'T'};
        visited = new HashSet<>();
        this.end = end;
        return dfs(start, 0);
    }

    private int dfs(String start, int count) {
        if (start.equals(end)) {
            return count;
        }
        char[] curr = start.toCharArray();
        for (int i = 0; i < start.length(); i ++) {
            char old = curr[i];
            for (char b : banks) {
                curr[i] = b;
                String newStr = new String(curr);
                if (!visited.contains(newStr) && bankLibrary.contains(newStr)) {
                    visited.add(newStr);
                    dfs(newStr, count + 1);
                    visited.remove(newStr);
                }
            }
            curr[i] = old;
        }
        return -1;
    }

}

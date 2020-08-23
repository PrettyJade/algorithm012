import java.util.HashSet;
import java.util.List;

/**
 * @author nanbeiyang
 * @version LadderLength.java, v 0.1 2020/8/22 4:45 下午  Exp $$
 * @name
 */
public class LadderLength2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }
        beginSet.add(beginWord);
        endSet.add(endWord);

        HashSet<String> visited = new HashSet<>();

        int count = 2;

        while (!beginSet.isEmpty()) {
            HashSet<String> newSet = new HashSet<>();
            for (String word : beginSet) {
                char[] charArray = word.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char ch = charArray[i];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (ch == k) {
                            continue;
                        }
                        charArray[i] = k;
                        String newWord = String.valueOf(charArray);
                        if (endSet.contains(newWord)) {
                            return count;
                        }
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            newSet.add(newWord);
                        }
                    }
                    charArray[i] = ch;
                }
            }
            if (newSet.size() > endSet.size()) {
                beginSet = endSet;
                endSet = newSet;
            } else {
                beginSet = newSet;
            }
            count ++;
        }
        return 0;
    }
}

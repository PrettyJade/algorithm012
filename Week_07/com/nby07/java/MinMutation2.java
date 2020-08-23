import java.util.Arrays;
import java.util.HashSet;

/**
 * @author nanbeiyang
 * @version MinMutation2.java, v 0.1 2020/8/23 8:41 下午  Exp $$
 * @name
 */
public class MinMutation2 {
    public int minMutation2(String start, String end, String[] bank) {
        // 双向bfs来解决这个问题
        HashSet<String> startSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        HashSet<String> visited = new HashSet<>();
        if (!bankSet.contains(end)) {
            return -1;
        }
        int count = 1;
        startSet.add(start);
        endSet.add(end);

        char[] bankChar = {'A', 'C', 'G', 'T'};

        while (!startSet.isEmpty()) {
            
            HashSet<String> newSet = new HashSet<>();
            for (String dna : startSet) {
                char[] charArray = dna.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char old = charArray[i];
                    for (char b : bankChar) {
                        charArray[i] = b;
                        String newDna = String.valueOf(charArray);
                        if (endSet.contains(newDna)) {
                            return count;
                        }
                        if (bankSet.contains(newDna) && !visited.contains(newDna)) {
                            visited.add(newDna);
                            newSet.add(newDna);
                        }
                    }
                    charArray[i] = old;
                }
            }
            if (newSet.size() > endSet.size()) {
                startSet = endSet;
                endSet = newSet;
            } else {
                startSet = newSet;
            }
            count ++;
        }
        return -1;
    }



}

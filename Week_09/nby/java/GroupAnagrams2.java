import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version GroupAnagrams.java, v 0.1 2020/9/7 9:28 下午  Exp $$
 * @name
 */
public class GroupAnagrams2 {
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 97]++;
            }
            StringBuilder sb = new StringBuilder(100);
            for (int num : count) {
                sb.append(num + '.');
            }
            map.computeIfAbsent(sb.toString(), unused -> new LinkedList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            map.computeIfAbsent(String.valueOf(array), un -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

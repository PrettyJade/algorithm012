import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nanbeiyang
 * @version GroupAnagrams.java, v 0.1 2020/7/16 5:40 下午  Exp $$
 * @name
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个结果集合map
        Map<String, ArrayList<String>> ans = new HashMap<>();

        for (String str : strs) {
            char[] count = new char[26];
            // 得出字符串中字符的个数
            for (char c : str.toCharArray()) {
                count[c - 'a'] ++;
            }

            // 将结果转为为字符串
            String key = String.valueOf(count);

            // key值相同为异位词，放到同一个列表里
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<String>());
            }
            ans.get(key).add(str);
        }

        return new ArrayList<List<String>>(ans.values());
    }

}

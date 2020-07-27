import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nanbeiyang
 * @version LetterCombinations.java, v 0.1 2020/7/26 11:12 下午  Exp $$
 * @name
 */
public class LetterCombinations {
    Map<Character, String> phone = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < digits.length(); i ++) {
            keys.add(phone.get(digits.charAt(i)));
        }
        dfs(res, "", keys, 0, digits.length());
        return res;

    }

    private void dfs(List<String> res, String s, List<String> keys, int level, int n) {
        if (s.length() == n) {
            res.add(s);
        }
        for (int i = level; i < keys.size(); i++) {
            for (int j = 0; j < keys.get(i).length(); j++) {
                dfs(res, s + keys.get(i).charAt(j), keys, i + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations letter = new LetterCombinations();
        letter.letterCombinations("23");
    }

}

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version GenerateParenthesis.java, v 0.1 2020/7/24 2:30 下午  Exp $$
 * @name
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0, 0, n, "", res);
        return res;
    }

    private void generate(int left, int right, int n, String s, List<String> res) {
        if (right == n) {
            res.add(s);
        }

        if (left < n) {
            generate(left + 1, right, n, s + "(", res);
        }
        if (right < left) {
            generate(left, right + 1, n, s + ")", res);
        }
    }

}

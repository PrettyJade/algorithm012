import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version Combine.java, v 0.1 2020/7/26 9:08 下午  Exp $$
 * @name
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, n, k, 1, new LinkedList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, int k, int level, LinkedList<Integer> cell) {
        if (k == cell.size()) {
            res.add(new LinkedList<>(cell));
        }
        for (int i = level; i <= n; i ++) {
            cell.add(i);
            dfs(res, n, k, i + 1, cell);
            cell.removeLast();
        }
    }


}

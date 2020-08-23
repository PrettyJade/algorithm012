import java.util.ArrayList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version SolveNQueens2.java, v 0.1 2020/8/21 4:15 下午  Exp $$
 * @name
 */
public class SolveNQueens2 {
    List<List<String>> ans = new ArrayList<>();
    int[] col, p, na, queen;
    int total;
    StringBuilder rowStr;
    public List<List<String>> solveNQueens(int n) {
        // 初始化，占领缓存，竖，撇，捺
        col = new int[n];
        p = new int[2 * n];
        na = new int[2 * n];
        queen = new int[n];
        total = n;
        rowStr = new StringBuilder();
        for (int i = 0; i < total; i++) {
            rowStr.append(".");
        }
        //dfs 和回溯
        backtrace(0);

        // 构成最终结果
        return ans;
    }

    private void addSolution() {
        List<String> temp = new ArrayList<>();
        for (int i : queen) {
            temp.add(new StringBuilder(rowStr).replace(i, i + 1, "Q").toString());
        }
        ans.add(temp);
    }

    private void backtrace(int level) {
        if (level == total) {
            addSolution();
            return;
        }

        for (int i = 0; i < total; i++) {
            if (isPlace(level, i)) {
                placeQueen(level, i);
                backtrace(level + 1);
                removePlace(level, i);
            }
        }

    }

    private void removePlace(int rowNum, int colNum) {
        col[colNum] = 0;
        p[rowNum + colNum] = 0;
        na[rowNum - colNum + total] = 0;
        queen[rowNum] = 0;
    }

    private void placeQueen(int rowNum, int colNum) {
        col[colNum] = 1;
        p[rowNum + colNum] = 1;
        na[rowNum - colNum + total] = 1;
        queen[rowNum] = colNum;
    }

    private boolean isPlace(int rowNum, int colNum) {
        return col[colNum] + p[rowNum + colNum] + na[rowNum - colNum + total] == 0;
    }
}
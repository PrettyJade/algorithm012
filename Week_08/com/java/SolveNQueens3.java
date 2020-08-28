import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version SolveNQueens.java, v 0.1 2020/8/25 5:51 下午  Exp $$
 * @name
 */
public class SolveNQueens3 {
    List<List<String>> ans = new ArrayList<>();
    int size; LinkedList<Integer> queen;
    char[] rowStr;
    int n ;

    public List<List<String>> solveNQueens(int n) {
        size = (1 << n) - 1;
        queen = new LinkedList<>();
        rowStr = new char[n];
        for (int i = 0; i < n; i++) {
            rowStr[i] = '.';
        }
        this.n = n;
        solve(0, 0, 0);
        return ans;
    }

    private void solve(int row, int ld, int rd) {
        if (row == size) {
            addSolution();
            return;
        }
        int mask = row | ld | rd;
        for (int i = 0, p = 1; i < n; i++, p <<= 1) {
            if ((mask & p) == 0) {
                queen.add(i);
                solve(row | p, (ld | p) << 1, (rd | p) >> 1);
                queen.removeLast();
            }
        }
    }

    private void addSolution() {
        List<String> temp = new ArrayList<>();
        for (int i : queen) {
            rowStr[i] = 'Q';
            temp.add(String.valueOf(rowStr));
            rowStr[i] = '.';
        }
        ans.add(temp);
    }
    public static void main(String[] args) {
        SolveNQueens3 queens = new SolveNQueens3();
        System.out.println(queens.solveNQueens(4));;
    }
}

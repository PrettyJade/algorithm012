import java.util.ArrayList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version SolveNQueens.java, v 0.1 2020/7/27 6:02 下午  Exp $$
 * @name
 */
public class SolveNQueens {
    int cols[];
    int ple[];
    int na[];
    int queens[];
    int n;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        cols = new int[n];
        ple = new int[2 * n];
        na = new int[2 * n];
        queens = new int[n];
        res = new ArrayList<>();
        this.n = n;
        backTrack(0);
        return res;
    }

    private void backTrack(int row) {
        if (n == row) {
            addSolution();
            return;
        }
        for (int i = 0; i < n; i ++) {
            if (isNotUnderAttach(row, i)) {
                placeQueen(row, i);
                backTrack(row + 1);
                removeQueen(row, i);
            }
        }
    }

    private void removeQueen(int row, int col) {
        cols[col] = 0;
        ple[row + col] = 0;
        na[row - col + n] = 0;
        queens[row] = 0;
    }

    private void placeQueen(int row, int col) {
        cols[col] = 1;
        ple[row + col] = 1;
        na[row - col + n] = 1;
        queens[row] = col;
    }

    private boolean isNotUnderAttach(int row, int col) {
        return cols[col] + ple[row + col] + na[row - col + n] == 0;
    }

    private void addSolution() {
        StringBuilder point = new StringBuilder();
        point.append(".".repeat(n));
        List<String> ans = new ArrayList<>();
        for (int queen : queens) {
            StringBuilder temp = new StringBuilder(point);
            ans.add(temp.replace(queen, queen + 1, "Q").toString());
        }
        res.add(ans);
    }

}

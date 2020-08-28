/**
 * @author nanbeiyang
 * @version TotalNQueens2.java, v 0.1 2020/8/25 5:20 下午  Exp $$
 * @name
 */
public class TotalNQueens2 {
    int size, count = 0;
    public int totalNQueens(int n) {
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    private void solve(int row, int ld, int rd) {
        if (row == size) {
            count ++;
            return;
        }

        int pos = size | ~(row | ld | rd);
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }
}

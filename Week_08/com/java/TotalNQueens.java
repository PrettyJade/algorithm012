/**
 * @author nanbeiyang
 * @version TotalNQueens.java, v 0.1 2020/8/25 4:51 下午  Exp $$
 * @name
 */
public class TotalNQueens {
    private int size;
    private int count;

    private void solve(int row, int ld, int rd) {
        System.out.println(String.format("%d, %d, %d, %d", row, ld, rd, size));
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p; // pos &= pos - 1;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public int totalNQueens(int n) {
        System.out.println("row, td, rd, size");

        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    public static void main(String[] args) {
        TotalNQueens queens = new TotalNQueens();
        queens.totalNQueens(4);
    }
}

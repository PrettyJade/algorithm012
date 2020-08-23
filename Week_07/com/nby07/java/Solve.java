/**
 * @author nanbeiyang
 * @version Solve.java, v 0.1 2020/8/20 7:19 下午  Exp $$
 * @name
 */
public class Solve {
    public void solve1(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(i, 0, board);
            dfs(i, m -1, board);
        }
        for (int i = 0; i < m; i++) {
            dfs(0, i, board);
            dfs(n - 1, i, board);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] board) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(i + 1, j, board);
        dfs(i, j + 1, board);
        dfs(i - 1, j, board);
        dfs(i, j - 1, board);
    }


    public static void main(String[] args) {

    }
}

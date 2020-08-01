/**
 * @author nanbeiyang
 * @version UpdateBoard.java, v 0.1 2020/7/29 12:35 下午  Exp $$
 * @name
 */
public class UpdateBoard {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }
        dfs(board, r, c);
        return board;
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r == board.length || c == board[r].length) {
            return;
        }
        if (board[r][c] == 'E') {
            char mCount = '0';
            for (int i = r - 1; i <= r + 1; i ++) {
                if (i >= 0 && i < board.length) {
                    for (int j = c - 1; j <= c + 1; j ++) {
                        if (j >= 0 && j < board[i].length) {
                            if (board[i][j] == 'M') {
                                mCount ++;
                            }
                        }
                    }
                }
            }
            if (mCount > '0') {
                board[r][c] = mCount;
            } else {
                board[r][c] = 'B';
                for (int i = r - 1; i <= r + 1; i ++) {
                    for (int j = c - 1; j <= c + 1; j++) {
                        dfs(board, i, j);
                    }
                }
            }
        }
    }

}

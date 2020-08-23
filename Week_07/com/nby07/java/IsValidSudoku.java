/**
 * @author nanbeiyang
 * @version IsValidSudoku.java, v 0.1 2020/8/21 5:25 下午  Exp $$
 * @name
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] col = new int[9][9];
        int[][] row = new int[9][9];
        int[][] square = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int squareIndex = (i / 3) * 3 + j / 3;
                    if (col[i][num] + row[j][num] + square[squareIndex][num] == 0) {
                        col[i][num] = 1;
                        row[j][num] = 1;
                        square[squareIndex][num] = 1;
                    } else {
                        return false;
                    }
                }

            }
        }
        return true;
    }

}

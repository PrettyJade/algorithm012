import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author nanbeiyang
 * @version SolveSudoku.java, v 0.1 2020/8/21 6:06 下午  Exp $$
 * @name
 */
public class SolveSudoku {
    int n = 9;
    int[][] col = new int[n][n + 1];
    int[][] row = new int[n][n + 1];
    int[][] square = new int[n][n + 1];
    HashMap<Integer, Integer> blank = new HashMap<>();
    char[][] board;
    public void solveSudoku(char[][] board) {
        // 初始化数据，包括所有的横，所有的竖，所有的正方形
        initData(board);
        // 通过回溯方法，
        backtrace(0, new ArrayList<>(blank.keySet()));
    }


    private void backtrace(int count, List<Integer> blankKey) {
        if (count == blankKey.size()) {
            addSolution(blankKey);
            return;
        }

        int index = blankKey.get(count);
        int row = index / n;
        int col = index % n;
        for (int i = 1; i <= n; i++) {
            if (isValid(row, col, i)) {
                placeNum(row, col, i);
                backtrace(count + 1, blankKey);
                removeNum(row, col, i);
            }
        }

    }

    private void addSolution(List<Integer> blankKey) {
        for (Integer index : blankKey) {
            int row = index / n;
            int col = index % n;
            board[row][col] = (char) (blank.get(index) + 48);
        }
    }

    private void removeNum(int i, int j, int num) {
        col[i][num] = 0;
        row[j][num] = 0;
        square[(i / 3) * 3 + j / 3][num] = 0;
        blank.put(i * n + j, 0);
    }

    private void placeNum(int i, int j, int num) {
        col[i][num] = 1;
        row[j][num] = 1;
        square[(i / 3) * 3 + j / 3][num] = 1;
        blank.put(i * n + j, num);
    }

    public boolean isValid(int i, int j, int num) {
        return col[i][num] + row[j][num] + square[(i / 3) * 3 + j / 3][num] == 0;
    }

    private void initData(char[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    blank.put(i * n + j, 0);
                } else {
                    int num = board[i][j] - '0';
                    this.col[i][num] = 1;
                    this.row[j][num] = 1;
                    square[(i / 3) * 3 + j / 3][num] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        SolveSudoku solveSudoku = new SolveSudoku();
        char[][] a = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku.solveSudoku(a);
    }
}

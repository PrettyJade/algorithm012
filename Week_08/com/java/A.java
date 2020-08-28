/**
 * @author nanbeiyang
 * @version A.java, v 0.1 2020/8/25 6:27 下午  Exp $$
 * @name
 */
public class A {
    int[] col, p, na;
    int total, count = 0;
    public int totalNQueens(int n) {
        // 初始化，占领缓存，竖，撇，捺
        col = new int[n];
        p = new int[2 * n];
        na = new int[2 * n];
        total = n;
        //dfs 和回溯
        backtrace(0);

        return count;
    }


    private void backtrace(int level) {
        if (level == total) {
            count ++;
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
    }

    private void placeQueen(int rowNum, int colNum) {
        col[colNum] = 1;
        p[rowNum + colNum] = 1;
        na[rowNum - colNum + total] = 1;
    }

    private boolean isPlace(int rowNum, int colNum) {
        return col[colNum] + p[rowNum + colNum] + na[rowNum - colNum + total] == 0;
    }
}

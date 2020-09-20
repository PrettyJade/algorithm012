package com.park;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version SolveSudoku2.java, v 0.1 2020/9/15 9:21 下午  Exp $$
 * @name
 */
public class SolveSudoku2 {
    private int n = 9;
    private int[] row = new int[n];
    private int[] col = new int[n];
    private int[] square = new int[n];
    private boolean valid = false;
    private List<int[]> blankKey = new ArrayList<>();
    private char[][] board;
    public void solveSudoku(char[][] board) {
        this.board = board;
        initData();
        dfs(0);
    }
    private void initData() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    blankKey.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - 48 - 1;
                    flip(i, j,  num);
                }
            }
        }
    }

    private void dfs(int count) {
        if (count == blankKey.size()) {
            valid = true;
            return;
        }
        int x = blankKey.get(count)[0];
        int y = blankKey.get(count)[1];
        int mask = ~(row[x] | col[y] | square[3 * (x / 3) + y / 3]) & 0x1ff;
        for (; mask > 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(x, y, digit);
            board[x][y] = (char) (digit + 48 + 1);
            dfs(count + 1);
            flip(x, y, digit);
        }

    }
    public void flip(int i, int j, int num) {
        row[i] ^= (1 << num);
        col[j] ^= (1 << num);
        square[3 * (i / 3) + j / 3] ^= (1 << num);
    }


    public static void main(String[] args) {
        int a = 5;
        System.out.println(Integer.bitCount(85));
    }

}

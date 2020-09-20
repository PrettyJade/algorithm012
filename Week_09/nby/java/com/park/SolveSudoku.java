package com.park;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nanbeiyang
 * @version SolveSudoku.java, v 0.1 2020/9/15 8:39 下午  Exp $$
 * @name
 */
public class SolveSudoku {
    private int n = 9;
    private int[][] row = new int[n][n + 1];
    private int[][] col = new int[n][n + 1];
    private int[][] square = new int[n][n + 1];
    private Map<Integer, Integer> blankMap = new HashMap<>();
    private List<Integer> blankKey;
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
                    blankMap.put(n * i + j, 0);
                } else {
                    int num = board[i][j] - '0';
                    row[i][num] = 1;
                    col[j][num] = 1;
                    square[squareIndex(i, j)][num] = 1;
                }
            }
        }
        blankKey = new ArrayList<>(blankMap.keySet());
    }

    private void dfs(int count) {
        if (count == blankKey.size()) {
            addSolution();
            return;
        }
        int num = blankKey.get(count);
        int x = num / n;
        int y = num % n;
        for (int i = 1; i <= n; i++) {
           if (isValid(x, y, i))  {
               placeNum(x, y, i);
               dfs(count + 1);
               removeNum(x, y, i);
           }
        }
    }

    private void addSolution() {
        for (Integer num : blankKey) {
            int x = num / n;
            int y = num % n;
            board[x][y] = (char) (blankMap.get(num) + 48);
        }
    }

    private void removeNum(int x, int y, int i) {
        row[x][i] = 0;
        col[y][i] = 0;
        square[squareIndex(x, y)][i] = 0;
        blankMap.put(blankIndex(x, y), 0);
    }

    private void placeNum(int x, int y, int i) {
        row[x][i] = 1;
        col[y][i] = 1;
        square[squareIndex(x, y)][i] = 1;
        blankMap.put(blankIndex(x, y), i);
    }

    private boolean isValid(int x, int y, int i) {
        return row[x][i] + col[y][i] + square[squareIndex(x, y)][i] == 0;
    }

    private int squareIndex(int x, int y) {
        return 3 * (x / 3) + y / 3;
    }

    private int blankIndex(int x, int y) {
        return n * x + y;
    }


}

package com.bfs;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/5/19
 * Talk is Cheap,Show me the Code.
 **/
public class BattleshipsinaBoard419M {
    public int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int ans = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }

                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }

                ans++;
            }
        }
        return ans;
    }


    public int countBattleships2(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int ans = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    ans++;
                    sink(board, i, j);
                }
            }
        }
        return ans;
    }

    public void sink(char[][] B, int i, int j) {
        if (i < 0 || j < 0 || i >= B.length || j >= B[i].length || B[i][j] != 'X') {
            return;
        }

        B[i][j] = '.';
        sink(B, i + 1, j);
        sink(B, i - 1, j);
        sink(B, i, j + 1);
        sink(B, i, j - 1);
    }

}

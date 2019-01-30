package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/27/18
 * Talk is Cheap,Show me the Code.
 **/
public class WordSearch79M {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        char[] ch = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, ch, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, char[] ch, int idx, int i, int j, boolean[][] visited) {
        if (idx == ch.length) { // important
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }

        if (visited[i][j]) {
            return false;
        }

        if (board[i][j] != ch[idx]) {
            return false;
        }

        visited[i][j] = true;

        boolean exist = dfs(board, ch, idx + 1, i + 1, j, visited) ||
                dfs(board, ch, idx + 1, i - 1, j, visited) ||
                dfs(board, ch, idx + 1, i, j - 1, visited) ||
                dfs(board, ch, idx + 1, i, j + 1, visited);
        visited[i][j] = false;
        return exist;

    }
}

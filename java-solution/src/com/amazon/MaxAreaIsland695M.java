package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class MaxAreaIsland695M {
    // same solution of NumberIsland200.java
    private int n; // row
    private int m; // col
    private int max;
    private int cur;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        n = grid.length;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    cur = 0;
                    dfs(grid, i, j);
                    max = Math.max(cur, max);
                }
            }
        }
        return max;

    }

    public void dfs(int[][] grid, int row, int col) {
        if (row >= n || col >= m || row < 0 || col < 0 || grid[row][col] == 0) {
            return;
        }
        cur++;
        grid[row][col] = 0;

        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
    }
}

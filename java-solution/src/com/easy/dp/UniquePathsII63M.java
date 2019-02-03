package com.easy.dp;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-02
 * Talk is Cheap,Show me the Code.
 **/
public class UniquePathsII63M {
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] c = new int[m][n];

        c[0][0] = grid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            if (grid[i][0] == 1) {
                c[i][0] = 0;
            } else {
                c[i][0] = c[i - 1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            if (grid[0][i] == 1) {
                c[0][i] = 0;
            } else {
                c[0][i] = c[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    c[i][j] = 0;
                } else {
                    c[i][j] = c[i - 1][j] + c[i][j - 1];
                }
            }
        }

        return c[m - 1][n - 1];
    }
}

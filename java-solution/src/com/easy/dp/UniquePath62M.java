package com.easy.dp;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class UniquePath62M {
    /**
     * we can C[i][j] represent the number of ways to get to pos[i][j], what we need is c[m-1][n-1];
     * base case : c[0][i] = c1,c[i][0] = 1;
     * C[i][j] = c[i-1][j] + c[i][j-1];
     **/
    public int uniquePaths(int m, int n) {
        int[][] c = new int[m][n];
        c[0][0] = 1;
        for (int i = 1; i < m; i++) {
            c[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            c[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                c[i][j] = c[i - 1][j] + c[i][j - 1];
            }
        }
        return c[m - 1][n - 1];
    }
}

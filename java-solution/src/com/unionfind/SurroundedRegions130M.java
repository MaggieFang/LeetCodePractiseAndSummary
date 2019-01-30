package com.unionfind;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/1/19
 * Talk is Cheap,Show me the Code.
 **/
public class SurroundedRegions130M {
    /**
     * KEYPOINTS:
     * <p>
     *   if not border constaint,we just traverse the matrix,to change the O to X.
     *   but it say the area connect the border with O  not change.
     *   So we can do dfs for the border point, and do dfs. fill it in another letter.such as $
     *   and then traverse the matrix,O->X, and $ restore to  O
     *
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n^2)
     * <p>
     * SPACE COMPLEXITY: O(n)
     * <p>
    **/
    public void solve(char[][] b) {
        if (b == null || b.length == 0 || b[0].length == 0) {
            return;
        }

        int n = b.length;
        int m = b[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && b[i][j] == 'O') {
                    dfs(b, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j] == 'O') b[i][j] = 'X';
                else if (b[i][j] == '$') b[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] b, int i, int j) {
        if (i < 0 || j < 0 || i >= b.length || j >= b[i].length || b[i][j] != 'O') {
            return;
        }
        b[i][j] = '$';
        dfs(b, i - 1, j);
        dfs(b, i + 1, j);
        dfs(b, i, j - 1);
        dfs(b, i, j + 1);
    }
}

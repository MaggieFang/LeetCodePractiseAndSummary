package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/11/19
 * Talk is Cheap,Show me the Code.
 **/
public class LongestIncreasingPathinaMatrix329H {
    /**
     * KEYPOINTS:
     * <p>
     * </p>
     * TIME COMPLEXITY: O(mn). Each vertex/cell will be calculated once and only once,
     * and each edge will be visited once and only once.
     Space complexity : O(mn). The cache dominates the space complexity.
     * <p>
     **/
    int m = 0;
    int n = 0;
    private final static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return 0;
        n = matrix[0].length;
        if (n == 0) return 0;
        int ans = 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }

        return ans;
    }

    public int dfs(int[][] A, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int ans = 1;
        for (int[] d : DIR) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && A[i][j] < A[x][y]) {
                ans = Math.max(ans, dfs(A, x, y, memo));
            }
        }
        memo[i][j] = ans;
        return memo[i][j];
    }

}

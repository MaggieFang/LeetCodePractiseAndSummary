package com.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/11/18
 * Talk is Cheap,Show me the Code.
 **/
public class NumberIsland200 {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY: O(m*n)
     * SPACE COMPLEXITY:O(m*n)
     * </p>
     **/
    int nr;
    int nc;

    void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {//grid[r][c] == '0' judge important. otherwise overflow
            return;
        }

        /**
         [1 1 1
         0 1 0
         1 1 1 ]
         when dfs[2,1],we also should dfs[2,0]
         **/
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        nr = grid.length;
        nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

}

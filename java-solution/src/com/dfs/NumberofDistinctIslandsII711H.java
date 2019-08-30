package com.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-29
 **/
public class NumberofDistinctIslandsII711H {
    int m = 0;
    int n = 0;
    private final static int CONST = 401;

    public int numDistinctIslands2(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Set<Set<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    Set<Integer> shape = new HashSet<>();
                    dfs(i, j, i, j, shape, grid);
                    //TODO 需要讲他normal化 https://blog.csdn.net/magicbean2/article/details/79282937
                    set.add(shape);

                }
            }
        }

        return set.size();
    }

    public void dfs(int sr, int sc, int i, int j, Set<Integer> shape, int[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        shape.add((i - sr) * 401 + (j - sc));
        dfs(sr, sc, i - 1, j, shape, grid);
        dfs(sr, sc, i + 1, j, shape, grid);
        dfs(sr, sc, i, j - 1, shape, grid);
        dfs(sr, sc, i, j + 1, shape, grid);
    }
}

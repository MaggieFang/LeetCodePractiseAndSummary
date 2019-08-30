package com.amazon;

import java.util.*;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/28/18
 * Talk is Cheap,Show me the Code.
 **/
public class NumberDistinctIslands694M {
    /**
     * KEYPOINTS:
     * <p>
     * use a stringBuilder to store the shape, o(original),l,r,u,d,b(back)
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(R*C)
     * <p>
     * SPACE COMPLEXITY: O(R*C)
     * <p>
     **/
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder shape = new StringBuilder();
                    dfs(grid, i, j, 'o', shape);//original
                    result.add(shape.toString());
                }
            }
        }
        return result.size();

    }

    public void dfs(int[][] grid, int i, int j, char c, StringBuilder shape) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        shape.append(c);
        dfs(grid, i - 1, j, 'l', shape);
        dfs(grid, i + 1, j, 'r', shape);
        dfs(grid, i, j - 1, 'u', shape);
        dfs(grid, i, j + 1, 'd', shape);
        shape.append('b'); //!!! back.otherwise {{1,1,0},{0,1,1},{1,1,1},{0,1,0}} both will be orbr,but actually they are not the same shape.
    }

    public static void main(String[] args) {
       HashSet<Integer> list = new HashSet<>();
        list.add(1);
        list.add(2);
        HashSet<Integer> list2 = new HashSet<>();
        list2.add(2);
        list2.add(1);
        System.out.println(list.equals(list2));
        HashSet<Set<Integer>> set = new HashSet<>();
        set.add(list);
        set.add(list2);
        System.out.println(set.size()+"");
        NumberDistinctIslands694M test = new NumberDistinctIslands694M();
        test.numDistinctIslands(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1}
        });
    }


}

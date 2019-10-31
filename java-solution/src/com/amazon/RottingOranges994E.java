package com.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-10-30
 **/
public class RottingOranges994E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * Typically bfs. add all the 2 into the queue as the first depth. for each iteration, poll all elements for the same level,
     * and for each element, update their neibour to 2 if it is 1. the answer increasec by 1 for each iteration.
     * </p>
     * TIME COMPLEXITY: O(m*n), since we visit each node once.
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int orangesRotting(int[][] grid) {
        int count = 0;
        int con = 1010;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dis = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int ans = 0;

        while (!q.isEmpty() && count > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] d : dis) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0 && grid[x][y] != 2) {
                        grid[x][y] = 2;
                        count--;
                        q.add(new int[]{x, y});
                    }
                }
            }
            ans++;
        }
        return count == 0 ? ans : -1;
    }
}

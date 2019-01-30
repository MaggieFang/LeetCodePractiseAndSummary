package com.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/4/19
 * Talk is Cheap,Show me the Code.
 **/
public class WallsandGates286M {
    public static final int EMPTY = Integer.MAX_VALUE;
    public static final int GATE = 0;
    public static final List<int[]> DIRECTIONS = Arrays.asList(new int[]{-1, 0},
            new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1});

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) {
            return;
        }
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0];
            int j = p[1];
            for (int[] d : DIRECTIONS) {
                int r = i + d[0];
                int c = j + d[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[i][j] + 1;
                q.add(new int[]{r, c});
            }
        }
    }

}

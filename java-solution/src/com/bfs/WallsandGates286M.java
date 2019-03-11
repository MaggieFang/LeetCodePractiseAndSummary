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
    private final static int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {

        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    q.add(i * n + j);
                }
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            int curX = cur / n;
            int curY = cur % n;
            for (int[] d : DIR) {
                int x = curX + d[0];
                int y = curY + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == EMPTY) {
                    rooms[x][y] = rooms[curX][curY] + 1;
                    q.add(x * n + y);
                }

            }
        }
    }

}

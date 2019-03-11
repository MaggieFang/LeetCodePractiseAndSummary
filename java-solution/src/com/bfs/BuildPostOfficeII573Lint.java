package com.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/17/19
 * Talk is Cheap,Show me the Code.
 **/
public class BuildPostOfficeII573Lint {
    private final static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m;
    int n;

    //从空地出发，memory limit了，说明0的比较多，所以我们可以尝试从房子出发
    public int shortestDistanceMemoryLimite(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 | grid[0].length == 0) {
            return -1;
        }
        m = grid.length;
        n = grid[0].length;
        int ans = Integer.MAX_VALUE;
        int houseNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houseNum++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int[] r = bfs(grid, i, j);
                    if (r[1] == houseNum) {
                        ans = Math.min(r[0], ans);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int[] bfs(int[][] grid, int i, int j) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        visited.add(i * n + j);
        q.add(i * n + j);
        int sum = 0;
        int cnt = 0;
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int cur = q.poll();
                size--;
                int curX = cur / n;
                int curY = cur % n;
                for (int[] dir : DIR) {
                    int x = curX + dir[0];
                    int y = curY + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != 2 && !visited.contains(x * n + y)) {
                        if (grid[x][y] == 1) {
                            visited.add(x * n + y);
                            sum += (step + 1);
                            cnt++;
                        } else if (grid[x][y] == 0) {
                            q.add(x * n + y);
                            visited.add(x * n + y);
                        }
                    }
                }
            }
            step++;
        }
        return new int[]{sum, cnt};
    }
  //accept and beat 74%
    public int shortestDistanceFromHouse(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 | grid[0].length == 0) {
            return -1;
        }
        m = grid.length;
        n = grid[0].length;
        int ans = Integer.MAX_VALUE;
        int houseNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houseNum++;
                }
            }
        }
        int[][][] dis = new int[houseNum][m][n];
        for(int k = 0; k < houseNum;k++){
            for(int i = 0; i < m;i++){
                Arrays.fill(dis[k][i], Integer.MAX_VALUE);
            }
        }

        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfsFromHouse(grid, i, j, dis, index++);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int tmp = 0;
                    for (int k = 0; k < houseNum; k++) {
                        if (dis[k][i][j] == Integer.MAX_VALUE) {
                            tmp = Integer.MAX_VALUE;
                            break;
                        }
                        tmp += dis[k][i][j];

                    }
                    ans = Math.min(ans, tmp);
                }

            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void bfsFromHouse(int[][] grid, int i, int j, int[][][] dis, int index) {
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(i * n + j);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int cur = q.poll();
                int curX = cur / n;
                int curY = cur % n;
                size--;
                for (int[] dir : DIR) {
                    int x = curX + dir[0];
                    int y = curY + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        dis[index][x][y] = step + 1;
                        q.add(x*n+y);//when find a empty,enqueue
                    }
                }
            }
            step++;
        }
    }

    public static void main(String[] args){
        BuildPostOfficeII573Lint t = new BuildPostOfficeII573Lint();
        System.out.println(t.shortestDistanceFromHouse(new int[][]{{0,1,0,0,0},{1,0,0,2,1},{0,1,0,0,0}}));
    }
}

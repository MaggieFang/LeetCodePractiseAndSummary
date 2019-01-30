package com.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/17/19
 * Talk is Cheap,Show me the Code.
 **/
public class ShortestDistancefromAllBuildings803Lint {
    private final static int[][] DIR = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m;
    int n;
    //TC， main及解释size的两个例子，一个是有到不了的，一个是注意layer step值的。再加一个最后没有一个可以到所有的
    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        m = grid.length;
        n = grid[0].length;
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
                    if (r[1] == houseNum) { // 因为1的也是不能通过的，例如main里边的例子(0,5)只能达到(0,4)跟(1,5)其他的"1"不能到，所以覆盖不了所有的1，所以这个不能算solution之一
                        ans = Math.min(r[0], ans);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public int[] bfs(int[][] grid, int i, int j) {
        int sum = 0;
        int step = 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(i * n + j);
        visited.add(i * n + j);
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) { //控制step的自增逻辑，因为一个点距离自增1只有他直接所有相邻的一圈都遍历完了，不能是认为DIR完了就可以。例如 {{1,0,0},{0,0,0},{0,0,1}},当(0,1)时候q进了(1,1),(0,2),若认为对DIR出来就可以step++,那(1,1)时候step变为了2，等会poll出(0,2)情况就错了，因为他需要的step是1
                int cur = q.poll();
                size--;
                int curX = cur / n;
                int curY = cur % n;
                for (int[] dir : DIR) {
                    int x = curX + dir[0];
                    int y = curY + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != 2 && !visited.contains(x * n + y)) {
                        if (grid[x][y] == 0) {
                            q.add(x * n + y);
                            visited.add(x * n + y);
                        } else if (grid[x][y] == 1) {
                            cnt++;
                            visited.add(x * n + y);
                            sum += (step + 1);
                        }
                    }
                }
            }
            step++;
        }
        return new int[]{sum, cnt};

    }

    public static void main(String[] args) {
        ShortestDistancefromAllBuildings803Lint t = new ShortestDistancefromAllBuildings803Lint();
        System.out.println(t.shortestDistance(new int[][]{{1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1}, {0, 1, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 1}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {0, 1, 1, 1, 1, 0}}));
    }

}

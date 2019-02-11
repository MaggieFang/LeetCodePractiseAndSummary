package com.mianjing.gou;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/4/19
 * Talk is Cheap,Show me the Code.
 **/
public class PeopleBike {
    //人多还是车多？距离相等怎么办？
    //如果仅仅给一个点，问离这个点最近的Bike，直接BFS即可。
    //如果没有距离相等的，求分配，使得全局距离最小，那么就是求出所有的人跟所有的车的相互距离，放到PQ，然后弹出最小，如果这个人跟这个车还没匹配，则分配
    //如果有tie的，KM算法 二分图 一边是人，一边是车，找subgraph, the edge set{E},no two edge on the same vertex.
    public List<int[]> pair(char[][] grid) {

        PriorityQueue<Info> q = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.distance - o2.distance;
            }
        });

        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'B') {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            if (grid[k][l] == 'P') {
                                Info info = new Info();
                                info.x = k;
                                info.y = l;
                                info.bikeX = i;
                                info.bikeY = j;
                                info.distance = Math.abs(k - i) + Math.abs(l - j);
                                q.add(info);
                            }
                        }
                    }
                }
            }
        }

        while (!q.isEmpty()){
            Info cur = q.poll();
            if(grid[cur.bikeX][cur.bikeY] != 'O' && grid[cur.x][cur.y] != 'O'){
                System.out.println("people["+cur.x+","+cur.y+"],bike ["+cur.bikeX+","+cur.bikeY+"],dis =" + cur.distance);
                grid[cur.bikeX][cur.bikeY] = 'O';
                grid[cur.x][cur.y] = 'O';
            }
        }
        return null;
    }


    static class Info {
        public int bikeX;
        public int bikeY;
        public int x;
        public int y;
        public int distance;
    }
}


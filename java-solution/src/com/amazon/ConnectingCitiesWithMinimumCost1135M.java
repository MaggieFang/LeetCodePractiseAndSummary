package com.amazon;

import java.util.Arrays;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-10-30
 **/
public class ConnectingCitiesWithMinimumCost1135M {
    /**
     * Clarification:
     * union-find
     * </p>
     * Keypoints:
     * notice the stop condition here: since there are N nodes, so, when we connect two together, we --N,
     * and when there N is 1, it means all nodes are connected.since there are N, if there are connected, there should be N - 1 times union.
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int minimumCost(int N, int[][] conn) {
        // PriorityQueue<int[]> q = new PriorityQueue<>((int[] o1, int[] o2) ->{
        //     return o1[2] - o2[2];
        // });
        Arrays.sort(conn, (a, b) -> a[2] - b[2]);
        int[] root = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            root[i] = i;
        }

        int ans = 0;
        for (int[] cur : conn) {
            int r1 = find(root, cur[0]);
            int r2 = find(root, cur[1]);
            if (r1 != r2) {
                root[r1] = r2;
                ans += cur[2];
                N--; //key!!!
            }

        }
        return N == 1 ? ans : -1;
    }

    private int find(int[] root, int x) {
        int cur = x;
        while (root[cur] != cur) {
            cur = root[cur];
        }
        return cur;
    }

    // private void connect(int x,int y,int[] root){
    //     int r1 = find(root,x);
    //     int r2 = find(root,y);
    //     if(r1 != r2){
    //         root[r1] = r2;
    //     }
    // }
}

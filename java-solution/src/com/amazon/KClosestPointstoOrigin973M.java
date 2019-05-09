package com.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-05-09
 * Talk is cheap,show me the Code.
 **/
public class KClosestPointstoOrigin973M {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> q = new PriorityQueue<>((int[] o1, int[] o2) -> o1[0]*o1[0]+ o1[1]*o1[1] - o2[0]*o2[0]-o2[1]*o2[1]);
        for(int[] p: points){
            q.add(p);

        }
        int[][] result = new int[K][2];
        int i = 0;
        while (!q.isEmpty() && i < K) {
            result[i++] = q.poll();
        }
        return result;
    }

}

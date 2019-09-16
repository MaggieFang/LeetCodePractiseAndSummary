package com.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-16
 **/
public class CampusBikes1057M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * n workers and m bikes, and m > n. solve this question using a greedy approach.
     * initiate a priority queue of bike and worker pairs,based on their distance.
     * Loop through all workers and bikes, calculate their distance, and then throw it to the queue.
     * Initiate a set to keep track of the bikes that have been assigned.
     * initiate a result array ans and fill it with -1. (unassigned)
     * and poll from the queue.
     * </p>
     * TIME COMPLEXITY: O(max(m*n,N*log(m*n))), m*n is the loop. Nlog(m*n) is polling result from the queue.
     * SPACE COMPLEXITY:O(m*n)
     * </p>
     **/

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Info> q = new PriorityQueue<>((Info o1, Info o2) -> {
            //if distance same, select people with smaller index; if people same,select people with smaller bike index
            int disDiff = o1.distance - o2.distance;
            if (disDiff != 0) return disDiff;
            int pDiff = o1.pIndex - o2.pIndex;
            if (pDiff != 0) return pDiff;
            return o1.bIndex - o2.bIndex;
        });

        int n = workers.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bikes.length; j++) {
                Info info = new Info(i, j, Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]));
                q.add(info);

            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int i = 0;
        HashSet<Integer> assigned = new HashSet<>();
        while (!q.isEmpty() && i < n) {
            Info info = q.poll();
            if (assigned.contains(info.bIndex) || ans[info.pIndex] != -1) continue; // important.
            ans[info.pIndex] = info.bIndex;
            assigned.add(info.bIndex);
            i++;
        }
        return ans;
    }


    class Info {
        int pIndex;
        int bIndex;
        int distance;

        public Info(int p, int b, int dis) {
            this.pIndex = p;
            this.bIndex = b;
            this.distance = dis;
        }
    }


}
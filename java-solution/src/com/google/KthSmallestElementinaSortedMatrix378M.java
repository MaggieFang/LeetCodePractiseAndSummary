package com.google;

import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-05-09
 * Talk is cheap,show me the Code.
 **/
public class KthSmallestElementinaSortedMatrix378M {
    /**
     * Clarification:
     * SuperUglyNumber313M
     * </p>
     * Keypoints:
     *  same idea with SuperUglyNumber313M. But there are some more tricks here. 1) to store the first row first.
     *  and when pop the smallest one, the next one to add is the next row with the same column.
     *   another reminder. the Info should implementa the Comparable interface for PriorityQueue
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Info> q = new PriorityQueue<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            q.add(new Info(0, i, matrix[0][i]));
        }
        while (k > 1) {
            Info min = q.poll();
            if (min.i < n - 1) {
                q.add(new Info(min.i + 1, min.j, matrix[min.i + 1][min.j]));
            }
            k--;
        }
        return q.poll().val;
    }

    public static class Info implements Comparable<Info>{
        int i;
        int j;
        int val;

        public Info(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Info o) {
            return this.val - o.val;
        }
    }
}

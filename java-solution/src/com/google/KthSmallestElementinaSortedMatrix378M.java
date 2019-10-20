package com.google;

import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-05-09
 * Talk is cheap,show me the Code.
 **/
public class KthSmallestElementinaSortedMatrix378M {
    /**
     * Clarification:
     * SuperUglyNumber313M, but this should use pq instead of treeset
     * </p>
     * Keypoints:
     * put smallest into pq firstly, and pollFirst out. and use this min poll value doing multiply, and push to the pq.
     * after n-1 times pollFirst. the next pollFirst is what we want.
     * But there are some more tricks here. 1) to store the first row matrix[0] first instead of matrix[0][0]
     * and when pop the smallest one, the next one to add is the next row with the same column.
     * Why it can do this? because it is sorted both in row and column
     *
     * TIME COMPLEXITY:  O(kNlogN) init is O(n) and each pop and push is O(nlogn)
     * SPACE COMPLEXITY: O(n)
     * </p>
     **/
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Info> q = new PriorityQueue<>((Info o1, Info o2) -> o1.val - o2.val);
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

    public static class Info {
        int i;
        int j;
        int val;

        public Info(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }


    }
}

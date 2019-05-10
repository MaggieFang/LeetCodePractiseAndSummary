package com.google;

import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-05-09
 * Talk is cheap,show me the Code.
 **/
public class KthSmallestNumberinMultiplicationTable668H {

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * binary search. low = 1, high = m*n, mid, then we need to compute the count of elements that are less than n
     * for a row i, its value is i,i*2,i*3...i*n.  so for a mid, the number of elements that are <= mid  is min(mid/i,n)
     *  in this way we can use O(m) to compute the number of elements that are <= mid.
     *   compare it with k, if count < k than low = mid+1;
     * </p>
     * TIME COMPLEXITY: O(m*log(n*m))
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public int findKthNumber2(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(mid / i, n);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        KthSmallestNumberinMultiplicationTable668H t = new KthSmallestNumberinMultiplicationTable668H();
        t.findKthNumber2(3, 3, 5);
    }

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * can use the same idea in KthSmallestElementinaSortedMatrix378M. but time limit exceed.
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Info> q = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) q.add(new Info(1, i, i));
        while (k > 1) {
            Info min = q.poll();
            if (min.i < m) {
                q.add(new Info(min.i + 1, min.j, (min.i + 1) * min.j));
            }
            k--;
        }
        return q.poll().val;
    }

    public static class Info implements Comparable<Info> {
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

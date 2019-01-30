package com.amazon;

import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/5/18
 * Talk is Cheap,Show me the Code.
 **/
public class KLargestElement703E {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }

    private PriorityQueue<Integer> q;
    private int k;

    public KLargestElement703E(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue();
        for (int i : nums) {
            q.add(i);
            if (q.size() > k) {
                q.poll();
            }
        }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.add(val);
        } else if (val > q.peek()) {
            q.poll();
            q.add(val);
        }
        return q.peek();
    }
}

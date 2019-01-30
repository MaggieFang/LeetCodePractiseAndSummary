package com.mianjing.fb;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/7/18
 * Talk is Cheap,Show me the Code.
 **/
public class KthLargestNumber215M {
    public int intfindKthLargestUseHeap(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(); //小对
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    /**
     * KEYPOINTS:
     * <p>
     * k = 1, it is the max number. k = length,it is the min number;
     * if they put in  decreasing order, what we find is the (k-1)th position number.
     * so we can transform it into quicksort.
     * selected and pivot. and put the number larger on the left side.
     * and smaller number on the right side. to find the pivot's pos.
     * if pos == k return; else if(pos > k) find it in the left side. else find it in right side;
     * In QuickSort, we pick a pivot element, then move the pivot element to its correct position and
     * partition the array around it. The idea is, not to do complete quicksort, but stop at the point
     * where pivot itself is k’th smallest element. Also, not to recur for both left and right sides of pivot,
     * but recur for one of them according to the position of pivot.
     * The worst case time complexity of this method is O(n2), but it works in O(n) on average.
     * n + 1/2 n + 1/4 n + 1/8 n + ..... < 2 n
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:QuickSort O(n^2) in best worse, and O(N)on average
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }

        return findKth(nums, 0, nums.length - 1, k - 1);
    }


    public int findKth(int[] nums, int s, int e, int k) {
        int pivot = nums[e];
        int order = s;
        int i = s;
        while (i < e) {
            if (nums[i] >= pivot) {
                int tmp = nums[order];
                nums[order] = nums[i];
                nums[i] = tmp;
                order++;
            }
            i++;
        }
        nums[e] = nums[order];
        nums[order] = pivot;

        if (order == k) {
            return nums[order];
        } else if (order > k) {
            return findKth(nums, s, order - 1, k);
        } else {
            return findKth(nums, order + 1, e, k);
        }
    }

    public int findKthLargestUseApi(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }



    public static void main(String[] arsg) {
        int[] A = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(new KthLargestNumber215M().findKthLargest(A, k));
    }
}

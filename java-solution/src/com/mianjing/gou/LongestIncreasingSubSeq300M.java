package com.mianjing.gou;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class LongestIncreasingSubSeq300M {
    /**
     * KEYPOINTS:
     * <p>
     * we make c[i] be the longest x[0,,i] that contains x[i]; how to get c[i]?
     * we should find the max{c[j]} of 0<= j < i at the same time only the x[j] < x[i]( to ensure we can include x[i]) ,
     * and the final result is the max{c[i]} 0<=i <n.20
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] A = new int[n];
        Arrays.fill(A, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    A[i] = Math.max(A[i], A[j] + 1);
                }
            }
            max = Math.max(max, A[i]);
        }
        return max;
    }


}

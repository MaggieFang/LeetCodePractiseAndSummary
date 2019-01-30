package com.array;

public class FindPivotIndex724E {
    /**
     * KEYPOINTS:
     * <p>
     * 1 7 3 6 5 6
     * index  leftsum    rightsum
     * 0      0           27
     * 1    0+ A[0] =1     27 - A[1] = 20
     * 2 .  1+ A[1] = 8 .   20 - A[2] = 17
     * 3    8+ A[2] = 11 .   17 - A[3] =  11;
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(N)
     * <p>
     * SPACE COMPLEXITY:O(1)
     * <p>
     **/
    public int pivotIndex(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        if (rightSum == leftSum) {
            return 0;
        }

        int i = 1;
        while (i < nums.length) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            i++;
        }
        return -1;
    }
}

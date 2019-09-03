package com.google;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-02
 **/
public class MedianofTwoSortedArrays4H {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:https://www.youtube.com/watch?time_continue=1&v=LPFhl65R7ww
     * partitionX + partitionY = (x+y+1)/2
     *  ...Xi, Xi+1....
     *  .....Yj, Yj+1
     *  if Xi <= Yj+1 && Yj <= Xi+1 we found the middian. and if x+y is odd, then result is Max(Xi,Yj) , else is (Max(Xi,Yj) + min(Xi+1,Yj+1))/2.0
     *
     *  So algorithm is
     * found:
     *  parXLeft <= parYright
     *  parYLeft <= parXright
     * else if parXleft > parYright
     *    move towards left in X;
     * else move towards right in X
     *
     * </p>
     * TIME COMPLEXITY: O(log(Min(n1,n2)))
     * SPACE COMPLEXITY:
     * </p>
     **/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;
        while (low <= high) {
            int parX = (low + high) / 2;
            int parY = (n1 + n2 + 1) / 2 - parX;
            // if partition X is 0 means there is no left side, use MIN for leftX;
            int leftX = parX == 0 ? Integer.MIN_VALUE : nums1[parX - 1];
            int rightX = parX == n1 ? Integer.MAX_VALUE : nums1[parX];
            int leftY = parY == 0 ? Integer.MIN_VALUE : nums2[parY - 1];
            int rightY = parY == n2 ? Integer.MAX_VALUE : nums2[parY];

            if (leftX <= rightY && leftY <= rightX) {
                if ((n1 + n2) % 2 == 1) {
                    return Math.max(leftX, leftY);
                } else {
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
                }
            } else if (leftX > rightY) {
                high = parX - 1;
            } else {
                low = parX + 1;
            }
        }
        return Double.MAX_VALUE;

    }
}

package com.amazon;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-02
 **/
public class NextGreaterElementI496E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * for each num in nums1, first find the index in nums2. indicated idx2, then from the idx2 try to find the first greater number.
     * </p>
     * TIME COMPLEXITY: O(m*n)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] r = new int[n1];
        for (int i = 0; i < n1; i++) {
            int idx2 = findIndexInSecond(nums1[i], nums2);
            while (idx2 < n2 && nums2[idx2] <= nums1[i]) {
                idx2++;
            }
            r[i] = idx2 == n2 ? -1 : nums2[idx2];
        }
        return r;
    }

    private int findIndexInSecond(int e, int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] != e) i++;
        return i;
    }
}

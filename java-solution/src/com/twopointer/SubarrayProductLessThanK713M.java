package com.twopointer;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-02
 * Talk is cheap,show me the Code.
 **/
public class SubarrayProductLessThanK713M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * slide window. windows keep  product < K, when we add a element(the right one), we try to calculate
     * the numbers of subarray that include the new added element that can keep the window.
     * 维护一个数字乘积刚好小于k的滑动窗口，用变量left来记录其左边界的位置，右边界i就是当前遍历到的位置。遍历原数组，用prod乘上当前遍历到的数字，
     * 然后进行while循环，如果prod大于等于k，则滑动窗口的左边界需要向右移动一位，删除最左边的数字，left自增1。当我们确定了窗口的大小后，
     * 就可以统计包含ith元素的子数组的个数了 = 窗口的大小。为啥呢，比如[5 2 6]这个窗口，k还是100，右边界刚滑到6这个位置，
     * 这个窗口的大小就是包含6的子数组乘积小于k的个数，即[6], [2 6], [5 2 6]，正好是3个。
     * 所以窗口每次向右增加一个数字，然后左边去掉需要去掉的数字后，窗口的大小就是新的子数组的个数，每次加到结果res中即可
     * </p>
     * TIME COMPLEXITY: O(N)
     * SPACE COMPLEXITY:O(1)
     * </p>
     **/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int pro = 1;
        for (int i = 0; i < nums.length; i++) {
            pro *= nums[i];
            while (pro >= k && left <= i) {
                pro /= nums[left++];
            }
            ans += (i - left + 1);
        }
        return ans;
    }
}

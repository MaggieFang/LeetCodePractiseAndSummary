package com.array;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/10/18
 * Talk is Cheap,Show me the Code.
 **/
public class MaxSumSubArray53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.printf(maxSumReccurence(nums) + "");
    }

    /**
     * KEYPOINTS:
     * <p>
     * 很多题，我们都是在处当前元素时候考虑当前元素要不要，但对于这道题，我们应该考虑当前元素是不是新的开始，
     * 之前的元素带来的影响是小于0的，那么我们肯定舍弃
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *    max = MIN;
     *    sum = 0;
     *    for i = 0 to n-1:
     *        if sum < 0
     *            sum = A[i]
     *        else
     *            sum += A[i]
     *        //说明这一轮带来的影响是正面的，如-1，1，-3，当sum = 1时，到-3元素。sum会变-2，所以我们用max保存1目前的最大
     *         if max < sum
     *                max = sum
     *    return max;
     * </code>
     * </pre>
     * TIME COMPLEXITY:  O{n}
     * <p>
     * SPACE COMPLEXITY:O{1}
     * <p>
     **/
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i : nums) {
            if (cur <= 0) {
                cur = i;
            } else {
                cur += i;
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    /**
     * KEYPOINTS:
     * <p>
     * brute loop.
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n^3)
     * <p>
     * SPACE COMPLEXITY:O(1)
     * <p>
     **/
    public static int maxSumOriginal(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int maxOneTurn = Integer.MIN_VALUE;
            for (int k = nums.length - 1; k >= i; k--) {
                int sum = 0;
                for (int j = k; j >= i; j--) {
                    sum += nums[j];
                }
                if (maxOneTurn < sum) {
                    maxOneTurn = sum;
                }
            }
            if (maxSum < maxOneTurn) {
                maxSum = maxOneTurn;
            }
        }
        return maxSum;
    }
}

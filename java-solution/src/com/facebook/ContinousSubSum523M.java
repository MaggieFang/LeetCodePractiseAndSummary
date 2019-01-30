package com.facebook;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class ContinousSubSum523M {
    /**
     * KEYPOINTS:
     * <p>
     *     same idea with SubArraySumK560M.java.
     *     but we just need to consider some situation:
     *     1) if all num in the array is 0, then it will always be true since 0*k = 0
     *     2) k == 0; return false;
     *     3) to avoid k < 0 the mod may be stange,we change k to abs(k). e.g 0 mod -1 will be 0,(I do not know why)
     *     actually, the code below. don't use absK, just use k is OK ~
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n^2)
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
    **/
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int n = nums.length;
        int absK = Math.abs(k);
        int z = 0;
        for (; z < nums.length; z++) {
            if (nums[z] != 0) {
                break;
            }
        }

        if (z == n) { //nums are all 0; so every k*0 will be 0 so return true;
            return true;
        }

        if (k == 0) {
            return false;
        }

        int sum = nums[0];
        for (int i = 0; i < n - 1; i++) {
            sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum % absK == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

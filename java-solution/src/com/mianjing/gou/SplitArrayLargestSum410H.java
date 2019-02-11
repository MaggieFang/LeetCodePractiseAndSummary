package com.mianjing.gou;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/10/19
 * Talk is Cheap,Show me the Code.
 **/
public class SplitArrayLargestSum410H {
    /**
     * KEYPOINTS:
     * the result must be in [Max,Sum]
     * so we can binary seach to find the target. assume the prior is [low,high]
     * when we get a mid, we try to valid mid can be a result.If yes,we can miminum our search area in [low,mid]
     * what means validate. for a given t,we try to check whether the array can be divided into
     * no more than m part. with the max subarray sum is not larger than t.
     * so we just try to divided the nums, when the sum >= t,it should be a new start of subarray, and count the part we divided
     * if >= m then return false
     * <p>
     * </p>
     * TIME COMPLEXITY:the cal is O(n) ,binary search for [max,sum] is log(sum), and the valid is O(n), so it is O(log(sum)*n)
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (m == 1) return (int) sum;

        long low = max;
        long high = sum;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (valid(mid, nums, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;

    }

    public boolean valid(long target, int[] nums, int m) {
        int count = 0;
        int cur = 0;
        for (int num : nums) {
            cur += num;
            if (cur > target) {
                cur = num;
                count++;
                if (count >= m) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * KEYPOINTS:
     * <p>
     * DP, define f[i][j] to be the minimum largest subarray sum for splitting nums[0..i] into j parts.
     * Consider the jth subarray. We can split the array from a smaller index k to i to form it.
     * Thus f[i][j] can be derived from Min(max(f[k][j - 1], nums[k + 1] + ... + nums[i])).
     * The final answer should be f[n][m], where n is the size of the array.
     * </p>
     * TIME COMPLEXITY:O(n^2*m)
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int splitArrayDP(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        int[] sum = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sum[i] - sum[k]));
                }
            }
        }

        return f[n][m];
    }

}

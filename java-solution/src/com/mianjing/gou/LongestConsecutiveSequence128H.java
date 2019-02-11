package com.mianjing.gou;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/9/19
 * Talk is Cheap,Show me the Code.
 **/
public class LongestConsecutiveSequence128H {

    /**
     * the number unique? of not how to define the result; OK maybe duplicate but count 1 on the result
     **/
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 1;
        int i = 0;
        int cnt = 1;
        while (i < nums.length - 1) {
            if (nums[i + 1] == nums[i]) {
                i++;
                continue;
            }

            if (nums[i + 1] - nums[i] == 1) {
                cnt++;
                max = Math.max(max, cnt);//不能在else里，可能一直走不到
            } else {
                cnt = 1;
            }
            i++;
        }
        return max;
    }

    /**
     * KEYPOINTS:
     * <p>
     *     improve from brute force. use set to contain the nums.to avoid the O(n) of contains
     *
     * </p>
     * TIME COMPLEXITY:O(n)
     * <p>
     * SPACE COMPLEXITY:O(n)
     * <p>
     **/
    public int longestConsecutiveImproveForBrute(int[] nums) {
        int ans = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int tmp = 1;
                int cur = n;
                while (set.contains(cur + 1)) {
                    cur += 1;
                    tmp += 1;
                }
                ans = Math.max(ans, tmp);

            }
        }
        return ans;
    }

    /**
     * KEYPOINTS:
     * <p>
     * brute force, for every num. attempting to count as high as the possible the num can add.
     * </p>
     * TIME COMPLEXITY: O(n^3) cubic
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
     **/
    public int longestConsecutiveBruteForce(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int cur = num;
            int tmp = 1;
            while (contains(nums, cur + 1)) {
                cur += 1;
                tmp += 1;
            }
            ans = Math.max(ans, tmp);

        }
        return ans;
    }

    public boolean contains(int[] arr, int num) {
        for (int n : arr) {
            if (n == num) return true;
        }
        return false;
    }

}

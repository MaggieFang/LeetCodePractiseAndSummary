package com.fb;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/8/18
 * Talk is Cheap,Show me the Code.
 **/
public class SubArraySumK560M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * An efficient solution is while traversing the array, store sum so far in currsum. Also maintain count of values of currsum in a map. (之前也可能出现这个和值)
     * If value of currsum is equal to desired sum at any instance increment count of subarrays by one.
     * curSum is the sum currently,  assume sum[i],sum[j], and if sum[i] - sum[j] == k,then it means the elements between j~i can build the result,too.
     * so for the curSum,we can check whether (curSum - k) has exist in the map. if yes, get (curSum-k) 's value, cnt, it means there are cnt cases before
     * can build the sum k with curSum. so add it.
     * 谷歌题目是让输出，那么map的value可以换成用List,存放该sum出现的index
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     * </p>
     **/
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        for (int cur : nums) {
            curSum += cur;
            if (curSum == k) {
                result++;
            }

            if (map.containsKey(curSum - k)) {
                result += map.get(curSum - k);
            }

            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return result;
    }

    // we can use fix start, and move on different end to caculate the sum;
    //e.g    100, 1,2,3
    // for  start = 0 to n-1 ;
    //    then end move from start to n -1;
    //    so we can calculate s[start], s[start,start+1],s[start,start+1,start+2]...
    // O(n^2) , Spacke O(1)
    public int subarraySumFixStartVaryEnd(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int reslut = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    reslut++;
                }
            }
        }
        return reslut;

    }

    /**
     * KEYPOINTS:
     * <p>
     * I call this Cummulative sum with increasing slide window.
     * [100,1,2,3]  k = 6
     * firstly we check every single number == k?  yes increasing result;
     * sec,we begin to check 2 nums' sum. so we can use fix slide window with size 2;
     * initSum = A[0]+A[1] and check if == k;
     * then we start to move the window. let i be the end of element so sum = sum +A[i] - A[i-1]; till i to n-1;
     * when we begin to check 3 nums' sum. we just add a[2] to the initSum.
     * then we start to move the window with size= 3, let i be the end of elem(start start with 2+1).
     * so sum = sum+ A[3] - A[0], sum = sum +A[4] - A[1];
     * som sum = sum + num[i] -
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(n^2)
     * <p>
     * SPACE COMPLEXITY:O(1)
     * <p>
     **/

    public int subarraySumSlide(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }

        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                ++result;
            }
        }

        int t = 2; // represen the total number we want to calculate;
        int initSum = nums[0];
        while (t <= n) {
            initSum += nums[t - 1];
            if (initSum == k) {
                result++;
            }

            int sum = initSum;
            // t represent that end with
            for (int i = t; i < n; i++) { // i < n 第一次错了
                sum = sum + nums[i] - nums[i - t]; // i-t-1 第一次错了
                if (sum == k) {
                    result++;
                }
            }
            t++;
        }
        return result;
    }

    public static void main(String[] args) {
        SubArraySumK560M test = new SubArraySumK560M();
        int[] A = new int[]{1, 1, 1};
        int[] B = new int[]{1, 2, 1, 2, 1};
        System.out.println(test.subarraySumSlide(B, 3));
    }
}

package com.linkedin;

import java.util.*;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-07
 **/
public class FindKPairswithSmallestSums373M {
    /**
     * Clarification:
     * A better one
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 == 0 || n2 == 0) return new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((int[] o1, int[] o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n1; i++) { // add the nums1[i]+ nums2[0] to the q first.
            q.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (k-- > 0 && !q.isEmpty()) {
            int[] cur = q.poll();
            List<Integer> e = new ArrayList<>();
            e.add(nums1[cur[1]]);
            e.add(nums2[cur[2]]);
            ans.add(e);
            if (cur[2] + 1 < n2) { // maybe new candidate
                q.add(new int[]{nums1[cur[1]] + nums2[cur[2] + 1], cur[1], cur[2] + 1});
            }
        }
        return ans;
    }

    /**
     * Clarification:
     * case [1,2,4,5,6],[3,5,7,9], k = 3, the result is [1,3],[2,3],[1,5] 所以注意pointer可能回去
     * </p>
     * Keypoints:
     * 这种方法我们从0循环到数组的个数和k之间的较小值，这样做的好处是如果k远小于数组个数时，我们不需要计算所有的数字对，而是最多计算k*k个数字对
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // find the candidate of min1*min2, then select the top k /min1*min2 result;
        int min1 = Math.min(k, n1);
        int min2 = Math.min(k, n2);
        TreeMap<Integer, List<Integer[]>> map = new TreeMap<>();
        for (int i = 0; i < min1; i++) {
            for (int j = 0; j < min2; j++) {
                int sum = nums1[i] + nums2[j];
                List<Integer[]> list = map.getOrDefault(sum, new ArrayList<>());
                list.add(new Integer[]{nums1[i], nums2[j]});
                map.put(sum, list);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer[]>> t : map.entrySet()) {
            if (ans.size() >= k) {
                break;
            }
            for (Integer[] e : t.getValue()) {
                ans.add(Arrays.asList(e));
                if (ans.size() >= k) {
                    break;
                }
            }

        }
        return ans;
    }
}

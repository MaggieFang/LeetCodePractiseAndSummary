package com.array;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class MajorityElement169 {

    /**
     * KEYPOINTS:
     * <p>
     * If we had some way of counting instances of the majority element as +1 and instances of any other element as −1,
     * summing them would make it obvious that the majority element is indeed the majority element.
     * we maintain a count, which is incremented whenever we see an instance of our current candidate for
     * majority element and decremented whenever we see anything else. Whenever count equals 0,
     * we effectively forget about everything in nums up to the current index and consider the current number
     * as the candidate for majority element
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(n)
     * <p>
     * SPACE COMPLEXITY:O(1)
     * <p>
     **/
    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            count += (candidate == i) ? 1 : -1;
        }
        return candidate;
    }


    /**
     * O(n) and O(n)
     **/
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i) && map.get(i) + 1 > nums.length / 2) {
                return i;
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return -1;
    }



}

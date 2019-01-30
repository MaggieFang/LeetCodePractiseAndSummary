package com.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class SingleNumber136 {
    public static void main(String[] args) {

    }

    /**
     * KEYPOINTS:
     * <p>
     * notice to practise traverse HasMap on blankboard.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY:O(n)
     * <p>
     **/
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : nums) {
            Integer v = map.get(e);
            if (v == null) {
                map.put(e, 1);
            } else {
                map.put(e, v + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * KEYPOINTS:
     * <p>
     *     Remember the MissingNumber268,we can use A^B^B = A
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int singleNumberXOR(int[] nums) {
        int r = 0;
        for (int e : nums) {
            r = r ^ e;
        }
        return r;
    }
}

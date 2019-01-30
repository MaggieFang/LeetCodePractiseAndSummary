package com.easy.hashtable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class IntersectionTwoArray350 {
    /**
     * KEYPOINTS:
     * <p>
     * Q1: What if the given array is already sorted? How would you optimize your algorithm?
     * A1: use two index to traverse the two array, the little one move forward.
     * when two element equals.add to the result

     * Q2:What if nums1's size is small compared to nums2's size? Which algorithm is better?
     * A2:Store the smaller one to the map, it save space.
     * Q3:What if elements of nums2 are stored on disk,
     * and the memory is limited such that you cannot load all elements into the memory at once?
     * A3:read it in chunks(read them in more than times.)
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

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : nums1) {
            Integer v = map.get(e);
            if (v == null) {
                map.put(e, 1);
            } else {
                map.put(e, v + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int e : nums2) {
            Integer v = map.get(e);
            if (v != null) {
                list.add(e);
                if (v == 1) {
                    map.remove(e);
                } else {
                    map.put(e, v - 1);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

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
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: nums2){
            int n = map.getOrDefault(i,0);
            n--;
            if(n >= 0){
                ans.add(i);
                map.put(i,n);
            }
        }
        int[] r = new int[ans.size()];
        int i = 0;
        for(int n : ans){
            r[i++] = n;
        }
        return r;
    }
}

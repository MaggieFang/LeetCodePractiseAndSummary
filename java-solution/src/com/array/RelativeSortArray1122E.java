package com.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-07-20
 **/
public class RelativeSortArray1122E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * if not required the left elements placed in ascending order. HashMap is enough.
     * when it comes to order, treeMap is what we consider.
     * But need to know that HashMap is O(1) for add/get/remove. but treeMap is O(logN) for them
     * another compromise can be firstly use the hashMap. the left one move to treeMap. or the left one can be store in
     * a temp array then sort them, then added to arr1.
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : arr1) {
            int v = map.getOrDefault(i, 0);
            map.put(i, v + 1);
        }
        int i = 0;
        for (int e : arr2) {
            int v = map.get(e);
            while (v > 0) {
                arr1[i++] = e;
                v--;
            }
            map.remove(e);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            int e = entry.getKey();
            while (v > 0) {
                arr1[i++] = e;
                v--;
            }
        }
        return arr1;
    }
}

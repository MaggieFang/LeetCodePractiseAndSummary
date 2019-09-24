package com.bb;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-23
 **/
public class SortCharactersByFrequency451M {
    /**
     * Clarification:
     * similar with LC347, 692
     * </p>
     * Keypoints:
     * use a map for freq count, then then use a prorityQueue, where element will store the key from the map
     * in comparing method. use the map to get the freq for comparing.
     * </p>
     * TIME COMPLEXITY: O(N)
     * SPACE COMPLEXITY: O(N)
     * </p>
     **/
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> q = new PriorityQueue<>((Character c1, Character c2) -> map.get(c2) - map.get(c1));
        for (Character c : map.keySet()) {
            q.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            int count = map.get(c);
            while (count-- > 0) {
                sb.append(c);
            }
        }
        int[][] a;
        return sb.toString();


    }
}

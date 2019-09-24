package com.bb;

import java.util.HashMap;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-23
 **/
public class LongestSubstringWithoutRepeatingCharacters3M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *
     *  a map to record the character's index. when there are duplicate. move the left to the index next to the character. should used
     *  left = Math.max(left, map.get(c) + 1); for some case left have been moved forward already..otherwise, we need to delete the char before that.
     *  e.g "abba", when i = 2, left will move to 2.when i = 3, map contains.but it didn't affect anymore since left have to to 2.
     *  but when
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = Integer.MIN_VALUE;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                //max = Math.max(max,i - left); // cannot put here. for those without duplicate, it will be wroing e.g s = " "
                left = Math.max(left, map.get(c) + 1);
            }
            max = Math.max(max, i - left + 1);
            map.put(c, i);
        }
        return max;
    }
}

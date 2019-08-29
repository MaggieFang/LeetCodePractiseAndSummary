package com.google;

import java.util.HashMap;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-28
 **/
public class LongestSubstringwithAtMostKDistinctCharacters340H {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * totally same as LongestSubstringwithAtMostTwoDistinctCharacters159H. just modify the judge from > 2 to > k
     *
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     * </p>
     **/
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), i);
            while (map.size() > k) {
                if (map.get(s.charAt(left)) == left) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            result = Math.max(result, i - left + 1);

        }
        return result;
    }
}

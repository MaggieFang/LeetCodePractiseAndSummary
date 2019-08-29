package com.google;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/13/19
 * Talk is Cheap,Show me the Code.
 **/
public class LongestSubstringwithAtMostTwoDistinctCharacters159H {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * "aabc": at first, I think i just need a set.and store the left index that from left to current, there are only 2 distinct char.
     * Once we meet a third one, we move our left to keep there are two distinct char. But e.g abaccc, when I meet c, what I erase is b not a.and move the left to 2
     * so set is not enough, I need a map to store the lastest index of char.
     * And once more than 2 distinct char, I move the left index, to see lastest index of it. if the lastest index == left. then it is the element to delete.
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:O(n)
     * </p>
     **/
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int result = 0;
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), i);
            while (map.size() > 2) {
                if (map.get(s.charAt(left)) == left) { // good! if the lastest index == left, it is the element to remove.
                    map.remove(s.charAt(left));
                }
                left++;
            }
            result = Math.max(result, i - left + 1);
        }

        return result;
    }
}

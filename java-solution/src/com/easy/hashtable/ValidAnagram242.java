package com.easy.hashtable;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class ValidAnagram242 {
    public static void main(String[] args) {

    }

    /**
     * KEYPOINTS:
     * <p>
     *    if two strings are anagram, the frequency of the letters will be the same.
     *    so we can count them.
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
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int num : count) {
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}

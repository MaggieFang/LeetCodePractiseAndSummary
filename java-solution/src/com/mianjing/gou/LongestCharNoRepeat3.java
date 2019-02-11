package com.mianjing.gou;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/2/18
 * Talk is Cheap,Show me the Code.
 **/
public class LongestCharNoRepeat3 {
    /**
     * KEYPOINTS:
     * <p>
     * slide window.
     * We use HashSet to store the characters in current window [i, j) (j = i initially).
     * Then we slide the index j to the right. If it is not in the HashSet, we slide j further.
     * Doing so until s[j] is already in the HashSet. At this point,
     * we found the maximum size of substrings without duplicate characters start with index i,
     * <p>
     * <p>
     * </p>
     * TIME COMPLEXITY:O(n)
     * <p>
     * SPACE COMPLEXITY:O(min(m,n)).The size of the Set is upper bounded by the size of the string n and
     * the size of the charset/alphabet m
     * <p>
     **/
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int ans = 0;
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
                ans = Math.max(ans, j - i);//！！！
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * KEYPOINTS:
     * <p>
     * use a map instead of a set.if s[j] have a duplicate in the range [i, j) with index j'
     * we don't need to increase ii little by little. We can skip all the elements in the range [i, j'] and
     * let i to be j' + 1 directly.
     * </p>
     * TIME COMPLEXITY:O(n)
     * <p>
     * SPACE COMPLEXITY:O(min(n,m))
     * <p>
     **/

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int ans = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < n && j < n) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }
            ans = Math.max(j - i + 1, ans);
            map.put(c, j);
            j++;
        }
        return ans;
    }


    public int lengthOfLongestSubstringBruteForce(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
            if (set.size() >= max) {
                max = set.size();
            }
        }
        return max;

    }


    /**
     * KEYPOINTS:
     * <p>
     * Handle the corner situation: when s == null or size 0,return 0; when size 1 return 1;
     * then we check the index 1, to save the max length that contains 1th.
     * We set A2 is the max length that contains s[i] every time when we traverse
     * when i +1, we check the last result substring contains s[i+1] or not.
     * if yes, we should move the start index to that we want for this time.
     * if not, the start will not move, same as the substring contains(i-1).
     * then store the max every time
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
    public int lengthOfLongestSubstringTmp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int A1 = 1;
        int A2 = 1; // the max length that must contains s[i]
        int start = 1;
        if (s.charAt(0) != s.charAt(1)) {
            A2 = 2;
            start = 0;
        }

        int max = Math.max(A1, A2);

        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            int end = start + A2;
            for (int j = start; j < end; j++) {
                if (s.charAt(j) == c) {
                    start = j + 1;   //the start index for substring contains s[i]
                }
            }
            int tmp = i - start + 1;  // the length that contains s[i]
            if (max < tmp) {
                max = tmp;

            }
            A2 = tmp;
        }
        return max;
    }


}

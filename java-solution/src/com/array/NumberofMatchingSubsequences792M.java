package com.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-26
 * Talk is cheap,show me the Code.
 **/
public class NumberofMatchingSubsequences792M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  build the dict of S,but since maybe duplicate,cannot use int[26], need a map<Char,List>
     *  check each word whether in dict,but need to keep the order. so use idx to store the index of S that have matched.
     * </p>
     * TIME COMPLEXITY: O(S.length + C) C is the total content of words.
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        // build the dict of S,but since maybe duplicate,cannot use int[26], need a map<Char,List>
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            ArrayList<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        //check each word whether in dict,but need to keep the order. so use idx to store the index of S that have matched.
        for (String s : words) {
            int idx = -1;
            int i = 0;
            for (; i < s.length(); i++) {
                char c = s.charAt(i);
                ArrayList<Integer> list = map.get(c);
                if (list == null) break;
                int pre = idx;
                for (int cur : list) {
                    if (cur > idx) {
                        idx = cur;
                        break;
                    }
                }
                if (pre == idx) break;
            }
            if (i == s.length()) ans++;

        }

        return ans;
    }
}

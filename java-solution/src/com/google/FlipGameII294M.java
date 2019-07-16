package com.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-07-15
 **/
public class FlipGameII294M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  firstly, how we find all possibilities of one-time convert?  OK. refer to LC293,
     *  then, for every possibility, if this possibility cannot win(means canWin(newPossibility) return false).
     *  then the current one should return true.
     *  so we need to memo all possibility win status.
     * </p>
     * TIME COMPLEXITY: O(N^2)? I think it is same with LC293.in this case, after we convert ++ to -- ,
     * the next recur is like in LC293 to get the next "++" from the last string.it will decrease on every recur.
     * SPACE COMPLEXITY: O(N)
     * </p>
     **/
    Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        if (s == null || s.length() == 0) return false;
        if (map.containsKey(s)) return map.get(s);
        int i = 0;
        while (i < s.length()) {
            int next = s.indexOf("++", i);
            if (next == -1) return false;
            String newS = new StringBuilder(s.substring(0, next)).append("--").append(s.substring(next + 2)).toString();
            if (!canWin(newS)) return true;
            map.put(newS, true);
            i = next + 1;
        }
        return false;
    }
}

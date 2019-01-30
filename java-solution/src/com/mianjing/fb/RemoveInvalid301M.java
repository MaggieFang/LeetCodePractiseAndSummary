package com.mianjing.fb;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/14/18
 * Talk is Cheap,Show me the Code.
 **/
public class RemoveInvalid301M {
    /**
     * KEYPOINTS:
     * <p>
     *     1. valid() to vaild the string
     *     2. invalidcount to count the invalid '（' and ')', they may be both 0, or both > 0 ")("
     *       or at least one > 0;
     *     3. add help(s,c1,c2, startIndex)
     *      when c1== c2 == 0 to check s if valid .yes add to result.
     *      when encount continous invalid '(' or ')' we can just delete the first one to avoid duplicate result.
     *
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
    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        if (isValid(s)) {
            ans.add(s);
            return ans;
        }

        int[] count = invalidNum(s);
        help(s, count[0], count[1], 0);
        return ans;

    }

    public void help(String s, int c1, int c2, int start) {
        if (c1 == 0 && c2 == 0) {
            if (isValid(s)) {
                ans.add(s);
                return;
            }
        }
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (c1 > 0 && s.charAt(i) == '(') {
                String sub = s.substring(0, i) + s.substring(i + 1);
                help(sub, c1 - 1, c2, i);
            }

            if (c2 > 0 && s.charAt(i) == ')') {
                String sub = s.substring(0, i) + s.substring(i + 1);
                help(sub, c1, c2 - 1, i);
            }

        }

    }

    public int[] invalidNum(String s) {
        int[] ans = new int[2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ans[0]++;
            } else if (c == ')') {
                if (ans[0] == 0) {
                    ans[1]++;
                } else {
                    ans[0]--;
                }
            }
        }
        return ans;
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')' && --count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}

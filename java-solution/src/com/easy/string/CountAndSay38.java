package com.easy.string;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/22/18
 * Talk is Cheap,Show me the Code.
 **/
public class CountAndSay38 {
    /**
     * KEYPOINTS:
     * <p>
     * we save n-1 result, in n iterator, we traverse the save result from 0 to length,
     * save the current char,count the same char number.when meets differ char,append the ones have count.
     * and begin the do the next differ char;
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
    public String countAndSay(int n) {
        StringBuilder pre = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder result = new StringBuilder();
            int count = 0;
            char cur = pre.charAt(0);

            for (int j = 0; j < pre.length(); j++) {
                if (pre.charAt(j) == cur) {
                    ++count;
                } else {
                    result.append(count).append(cur);
                    cur = pre.charAt(j);
                    count = 1;
                }
            }
            result.append(count).append(cur);
            pre = result;
        }
        return pre.toString();
    }
}

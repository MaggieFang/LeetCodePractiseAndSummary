package com.google;

import java.util.HashSet;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-27
 **/
public class CrackingtheSafe753M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * for a n-digital number filling with 0..k-1, there are k^n combinations.
     * for a new n-digital number, we try to reuse the prior one's last n-1 digits.
     * so firstly,we initial the res with n-digital '0', and then retrieve the last n-1 digits.
     * and try to append a new char from k-1.. 0, but we need to store what have been visited.
     * </p>
     * TIME COMPLEXITY: 
     * SPACE COMPLEXITY:
     * </p>
     **/
    public String crackSafe(int n, int k) {
        StringBuilder res = new StringBuilder();
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) { // initial with n-digits 0.
            res.append('0');
        }
        visited.add(res.toString()); //add to visited.

        int cnt = (int) Math.pow(k, n);// the number of cases of combination
        for (int idx = 0; idx < cnt - 1; idx++) {
            String cur = res.substring(res.length() - n + 1); // retrieve the last n-1 digits.
            for (int j = k - 1; j >= 0; j--) {//should be from k-1. otherwise if want to increasing order, res init with 'k-1'
                String test = cur + j;
                if (!visited.contains(test)) {
                    visited.add(test);
                    res.append(j);
                    break;
                }
            }
        }
        return res.toString();
    }
}

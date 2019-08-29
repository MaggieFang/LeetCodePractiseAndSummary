package com.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-25
 **/
public class DifferentWaystoAddParentheses241M {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int m = 0; m < left.size(); m++) {
                    for (int n = 0; n < right.size(); n++) {
                        if (c == '+') res.add(left.get(m) + right.get(n));
                        else if (c == '-') res.add(left.get(m) - right.get(n));
                        else if (c == '*') res.add(left.get(m) * right.get(n));
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.parseInt(input));
        return res;
    }
}

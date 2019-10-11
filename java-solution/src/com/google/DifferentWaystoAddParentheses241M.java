package com.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-25
 **/
public class DifferentWaystoAddParentheses241M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * this can be generalize into () ? (), e.g 2 -1 + 1 , we can be (2-1) + 1, 2- (1+1).
     * so a tipical divide and conquer question.
     * and of course, we can use a map to store the sub result for reuse.(use a map, key is the input string, value is list<Integer> result of this input string)
     * so, iterate each char in the input. when the cur char is an operator(*,+,-),
     * we call the same function to compute the result of the left sub and right sub respectively.
     *  when get the result leftList and rightList. compute their combination add to result.
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    HashMap<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input); // for improvement, store tue sub result for reuse.
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
        map.put(input,res);
        return res;
    }
}

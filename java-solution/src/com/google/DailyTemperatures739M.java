package com.google;

import java.util.Stack;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-02
 **/
public class DailyTemperatures739M {


    /**
     * Clarification:  when equals situation? [42,42,39,51]
     *
     * </p>
     * Keypoints:
     *  use a stack. from the back.when come to a element,try to find the index that are larger than this element.
     *  no need to concern that maybe some pop index will be used latter. no such case since when it pop, it means there are
     *  index that are smaller can be used. 
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     * </p>
     **/
    public int[] dailyTemperatures2(int[] T) {
        if (T == null || T.length == 0) {
            return new int[]{};
        }
        int[] r = new int[T.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) stack.pop();
            r[i] = stack.size() > 0 ? stack.peek() - i : 0;
            stack.push(i);
        }
        return r;

    }


    //O(n^2),别忘了问等于的情况例如[42,42,39,51]
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[]{};
        }

        int n = T.length;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && T[j] <= T[i]) j++;
            if (j >= n) r[i] = 0;
            else r[i] = j - i;
        }
        return r;

    }
}

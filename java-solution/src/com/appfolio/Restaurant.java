package com.appfolio;

import java.util.Stack;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-26
 **/
public class Restaurant {
    public int get_restaraunts(int l, int r, int t, int b) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{l, r, t, b});
        int sum = 0;
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int c = get_resutaurant(cur[0], cur[1], cur[2], cur[3]);
            if (c >= 50) {
//                stack.push()
                //分成四个
            } else {
                sum += c;
            }

        }
        return 0;

    }

    public int get_resutaurant(int l, int r, int t, int b) {
        return 0;
    }
}

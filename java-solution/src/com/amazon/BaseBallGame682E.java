package com.amazon;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class BaseBallGame682E {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String c = ops[i];
            if ("C".equals(c) && !stack.isEmpty()) {
                stack.pop();
            } else if ("D".equals(c)) {
                stack.push(stack.peek() * 2);
            } else if ("+".equals(c) && stack.size() >= 2) {
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

}

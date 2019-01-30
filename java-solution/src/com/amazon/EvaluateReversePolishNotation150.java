package com.amazon;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/27/18
 * Talk is Cheap,Show me the Code.
 **/
public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] t) {
        if (t == null || t.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();

        for (String tmp : t) {
            if ("+".equals(tmp)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else if ("-".equals(tmp)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if ("*".equals(tmp)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if ("/".equals(tmp)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(tmp));
            }

        }
        return stack.pop();
    }
}

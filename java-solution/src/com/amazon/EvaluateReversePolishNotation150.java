package com.amazon;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/27/18
 * Talk is Cheap,Show me the Code.
 **/
public class EvaluateReversePolishNotation150 {
    // 二刷，引入了下regual expression
    public int evalRPN2shua(String[] tokens) {
        Pattern patter = Pattern.compile("[0-9]+");
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (patter.matcher(s).find()) {
                stack.push(Integer.parseInt(s));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();
                if ("+".equals(s)) {
                    stack.push(n1 + n2);
                } else if ("-".equals(s)) {
                    stack.push(n1 - n2);
                } else if ("*".equals(s)) {
                    stack.push(n1 * n2);
                } else {
                    stack.push(n1 / n2);
                }
            }
        }
        return stack.peek();
    }

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

package com.google;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/13/19
 * Talk is Cheap,Show me the Code.
 **/
public class BasicCalculator224H {
    /**
     * Clarification:
     * </p>
     * Keypoints:
     *  1. consider '-' as a sign for the number after it. so all are '+' operation,i.e A-B = A+(-B)
     *  but if something like (A - (B - C)) we need to associate the negative sign with the result of B-C instead of with B
     *  2. we can calculate most of the expression on-the go. (7-(8+9)), we can calculate 8+9 before pushing to stack.
     *  so when meet a '(', we  push the calculated result and the sign(can use 1/-1 instead of +/-),
     *  the initial result and sign is 0 and 1 respectively.
     *  so in this example, we will push 0 and +, and calculate result = 7,sign = -1,when meet second '(', we push 7(actually pop sign to operate on it)
     *  and -1,
     *  reset the result and sign to 0 and 1 respectively. then on the go calculated result for 8+9 = 17,when meet ")",
     *  we pop the sign from stack and operative it on result gets -17 and pop the prior number we put there ,add it with result and push back
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();

        int sign = 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    ++i;
                }
                result += sign * sum;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0; //reset
                sign = 1;//reset
            } else if (c == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;

    }
}

package com.doordash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/20/19
 * Talk is Cheap,Show me the Code.
 **/
public class Caculator {
    public int cal(String s) {
        String[] sp = s.split(" ");
        int num = 0;
        String op = "+";
        HashSet<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sp.length; i++) {
            String cur = sp[i];
            if (!ops.contains(cur)) {
                num = Integer.parseInt(cur);
            }
            if (ops.contains(cur) || i == sp.length - 1) {
                if (op.equals("+")) {
                    stack.push(num);
                }else if(op.equals("-")) {
                    stack.push(-num);
                }else if (op.equals("*")) {
                    stack.push(stack.pop() * num);
                } else if (op.equals("/")) {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                op = cur;
            }
        }
        int ans = 0;
        for (int i : stack) {
            ans += i;
        }

        return ans;
    }

    public static void main(String[] args) {
        Caculator caculator = new Caculator();
        String s = "1 - 4 / 3";
        System.out.println(caculator.cal(s));
    }
}


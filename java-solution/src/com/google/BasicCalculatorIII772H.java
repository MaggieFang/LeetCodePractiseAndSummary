package com.google;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/14/19
 * Talk is Cheap,Show me the Code.
 **/
public class BasicCalculatorIII772H {
//    public int calculate(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        while (sb.indexOf("(") >= 0) {
//            int begin = sb.indexOf("(");
//            int end = sb.indexOf(")");
//            String sub = sb.substring(begin + 1, end);
//            sb.replace(begin, end + 1, calculateWithoutParenthese(sub) + "");
//        }
//        return calculateWithoutParenthese(sb.toString());
//    }
//
//    public int calculateWithoutParenthese(String s) {
//        Stack<Integer> stack = new Stack<>();
//        char op = '+';
//        int num = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (Character.isDigit(c)) {
//                num = num * 10 + c - '0';
//            }
//            if (Character.isDigit(c) && c != ' ' || i == s.length() - 1) { //这里必须是if，不能是上一个的else if,不然1+2的2不能被推进stack
//                if (op == '+') {
//                    stack.push(num);
//                } else if (op == '-') {
//                    stack.push(-num);
//                } else if (op == '*') {
//                    stack.push(stack.pop() * num);
//                } else if (op == '/') {
//                    stack.push(stack.pop() / num);
//                }
//                num = 0;
//                op = c;
//            }
//
//        }
//        int ans = 0;
//        while (!stack.isEmpty()) {
//            ans += stack.pop();
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        BasicCalculatorIII772H t = new BasicCalculatorIII772H();
//        System.out.println(t.calculate("1+1"));
//    }
}

package com.appfolio;

import java.util.Stack;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-25
 **/
public class DeleteCaseCharacter {
    /**
     * Clarification:
     *如果一个字母的大写和小写连续出现，则删除掉
     *  "aabBcc" -> "aacc"
     * - "AAAaaa" -> "AAaa" -> "Aa" -> ""
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public static String delete(String s) {
        if (s == null || s.length() <= 1) return s;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || Math.abs(stack.peek() - c) != 32) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.length() == 0 ? "" : sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(delete("aaBbcc"));
        System.out.println(delete("AAAaaa"));
        System.out.println(delete("AAAaBbab"));
    }
}

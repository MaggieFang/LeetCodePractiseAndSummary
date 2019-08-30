package com.string;

import java.util.Stack;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-29
 **/
public class SmallestSubsequenceofDistinctCharacters1081M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * keep the last index of each character (int[26])
     * then use a stack to push element,before push, if the current character is smaller than the peek
     * and the last index of peek is larger than the current char index. it means the peek element can be pushed some time latter.
     * so we pop them out.
     * finally, the stack store the element that from the small to larger subsequence.
     *
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:O(26)
     * </p>
     **/
    public String smallestSubsequence(String text) {
        int[] last = new int[26];
        for (int i = 0; i < text.length(); i++) {
            last[text.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (seen[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c && last[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            seen[c - 'a'] = true;

        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();


    }
}

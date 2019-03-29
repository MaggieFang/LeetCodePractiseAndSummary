package com.fb;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-28
 * Talk is cheap,show me the Code.
 **/
public class ReverseWordsinaString151M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  from the right, find the first non-space as the end,adn use s.lastIndexOf(' ',end) to find the start.then append [start,end] to the sb
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;
            int start = s.lastIndexOf(' ', i);
            sb.append(' ');
            sb.append(s, start + 1, i + 1);
            i = start - 1;
        }

        if (sb.length() > 0) sb.deleteCharAt(0);
        return sb.toString();

    }
}

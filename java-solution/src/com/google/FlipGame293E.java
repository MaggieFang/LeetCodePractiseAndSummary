package com.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-07-15
 **/
public class FlipGame293E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * from the beginning, find the next "++",use indexOf("++",i);
     * then you know where the next "++" to convert into '--' and then add it to result
     * </p>
     * TIME COMPLEXITY: O(n^2)
     * SPACE COMPLEXITY: O(1) if the result  List<string> is not included
     * </p>
     **/
    public List<String> generatePossibleNextMoves(String s) {
        List<String> r = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int next = s.indexOf("++", i); // little trick
            if (next == -1) {
                return r;
            }
            StringBuilder sb = new StringBuilder(s.substring(0, next)).append("--").append(s.substring(next + 2));
            r.add(sb.toString());
            i = next + 1;
        }
        return r;
    }

    public static void main(String[] args) {
        FlipGame293E t = new FlipGame293E();
        System.out.println(t.generatePossibleNextMoves("++++"));
    }
}

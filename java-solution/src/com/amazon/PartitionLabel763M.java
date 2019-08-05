package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class PartitionLabel763M {
    /**
     * Clarification:
     *
     * </p >
     * Keypoints:
     * firstly, we need to find the last index for each character in the string.
     * then from the beginning,when meet an character in index i, get the lastIndex.
     * so this partition at least  [i, lastIndex], but maybe there are some other character between i,lastIndex and
     * the last index for it maybe further. so we need to explore and expand the lastIndex
     * </p >
     * TIME COMPLEXITY: O(n^2)
     * SPACE COMPLEXITY: O(C)
     * </p >
     **/
    public List<Integer> partitionLabels(String S) {
        List<Integer> r = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < S.length()) {
            int end = lastIndex[S.charAt(i) - 'a'];
            int j = i + 1;
            while (j < end) {
                end = Math.max(end, lastIndex[S.charAt(j) - 'a']);
                j++;
            }
            r.add(end - i + 1);
            i = end + 1;
        }
        return r;
    }
}

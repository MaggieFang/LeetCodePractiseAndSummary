package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class PartitionLabel763M {
    /**
     * KEYPOINTS:
     * <p>
     *     简化版本
     *     last[26] store the last Index of every letter
     *     iterate S i = 0 to s.length
     *        j = Max{j,last[S[i]}
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/
    public List<Integer> partitionLabels1(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public  static List<Integer> partitionLabels(String S) {

        int[] index = new int[26];

        for (int i = 0; i < S.length(); ++i)
            index[S.charAt(i) - 'a'] = i;

        List<Integer> ans = new ArrayList<>();
        int lastIndex = 0;
        int start = 0;
        int curStart = 0;
        while(lastIndex < S.length()){
            curStart = lastIndex;
            while(start <= lastIndex){
                char c = S.charAt(start);
                int last = index[c-'a'];
                lastIndex = Math.max(last,lastIndex);
                start++;
            }
            ans.add(lastIndex - curStart + 1);
            lastIndex++;
        }
        return ans;

    }
    public static void main(String[] args){
        partitionLabels("ababcbacadefegdehijhklij");
    }
}

package com.easy.string;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/22/18
 * Talk is Cheap,Show me the Code.
 **/
public class LongestCommonPrefix28 {
    public static void main(String[] args) {
        //["a"]
        char c = 0;
        System.out.println(c);
        String[] s = new String[]{
                "flower", "flow", "flight"
        };

//        System.out.println(longestCommonPrefix(s));
    }

    /**
     * KEYPOINTS:
     * <p>
     * common prefix, it must the the 0 index of every string.
     * So we can compare vertically. the same index of every string.
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n) n is the total character of all strings
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
     **/
    public String longestCommonPrefixVerticalCompare(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int i = 0;
        for (; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) { //do not forget i >= strs[j].length() judgement
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }

    public String longestCommonPrefixHorizonCompare(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        int i = 1;
        while (i < strs.length) {
            if (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                i = 1;
            }else {
                ++i;
            }
            if(prefix.isEmpty()){
                return "";
            }
        }
        return prefix;
    }
}

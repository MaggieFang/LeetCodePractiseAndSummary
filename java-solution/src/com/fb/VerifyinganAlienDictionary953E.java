package com.fb;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-25
 * Talk is cheap,show me the Code.
 **/
public class VerifyinganAlienDictionary953E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * check whether all adjacent words a and b have a <= b. consider the compareTo function in java.
     * we can just implement a similar function to compare two string by their order.
     *  and then check all adjacent words a and b have a <= b.
     * </p>
     * TIME COMPLEXITY: O(C),C is the total content of the words
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) return true;

        int[] lorder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            lorder[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!smaller(words[i - 1], words[i], lorder)) {
                return false;
            }
        }
        return true;
    }


    public boolean smaller(String s1, String s2, int[] order) {
        int i = 0;
        int j = 0;
        int len1 = s1.length();
        int len2 = s2.length();

        while (i < len1 && j < len2) {
            char c1 = s1.charAt(i++);
            char c2 = s2.charAt(j++);
            int i1 = order[c1 - 'a'];
            int i2 = order[c2 - 'a'];
            if (i1 > i2) {
                return false;
            } else if (i1 < i2) { //!!!注意这里，只要一旦第一个单词靠左边的顺序比第二个单词小，就可以返回true.就跟字典一样
                return true;
            }
        }

        if (i < len1 && j >= len2) {
            return false;
        }
        return true;
    }
}

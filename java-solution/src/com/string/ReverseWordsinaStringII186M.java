package com.string;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-28
 * Talk is cheap,show me the Code.
 **/
public class ReverseWordsinaStringII186M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * we reverse all the char in the string(make it to char[] easily without extra stringBuilder); then reverse each part internally of string.
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int i = 0;
        int j = 0;
        while (j < str.length) {
            while (j < str.length && str[j] != ' ') j++;
            reverse(str, i, j - 1);
            i = j + 1;
            j = i;
        }
    }

    public void reverse(char[] str, int i, int j) {
        while (i < j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
    }
}

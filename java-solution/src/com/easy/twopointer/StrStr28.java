package com.easy.twopointer;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class StrStr28 {
    public static void main(String[] args) {
        System.out.println(strStr("", ""));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() < 1) {
            return 0;
        }
        if (haystack == null || haystack.length() < 1) {
            return -1;
        }
        int i = 0;
        int diff = haystack.length() - needle.length(); //if the left length of haystack less than needle's length(),the result must -1
        char begin = needle.charAt(0);
        while (i <= diff) { //donnot ignore =, e.g. "a","a"
            if (haystack.charAt(i) != begin) {
                ++i;
            } else {
                int j = 1;
                while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                    ++j;
                }
                if (j == needle.length()) {
                    return i;
                } else {
                    ++i;
                }
            }

        }

        return -1;
    }
}

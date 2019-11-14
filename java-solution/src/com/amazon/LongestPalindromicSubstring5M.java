package com.amazon;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-10-31
 **/
public class LongestPalindromicSubstring5M {
    /**
     * Clarification:
     * dp good!
     * better solution is Expand Around Center, seen below
     * </p>
     * Keypoints:
     * if we know "bab" is palindrome, then "mbabm" should be.
     * so let dp[i][j] true if substring [i,j] is palindrome
     * so dp[i][i] means only one character, it should be true;
     * dp[i][j] : if j == i+1 means neibouring element. if s[i] == s[j] it should be true;
     * and if j > i + 1, dp[i][j]  = (s[i] == s[j] && dp[i+1][j-1])'
     * </p>
     * TIME COMPLEXITY: O(N^2)
     * SPACE COMPLEXITY: O(N^2)
     * </p>
     **/
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int left = 0;
        int right = 0;
        for (int i = 1; i < len; i++) {
            char c1 = s.charAt(i);
            for (int j = i - 1; j >= 0; j--) {
                char c2 = s.charAt(j);
                // dp[j][i] = (c1 == c2) && (j == i -1 || dp[j+1][i-1]); 简化版
                if (c1 == c2) {
                    if (j == i - 1) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] && right - left < i - j) {
                    left = j;
                    right = i;
                }
            }
        }
        return s.substring(left, right + 1);

    }

    /**
     * Clarification:
     * Expand Around Center
     * </p>
     * Keypoints:
     * a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n - 1 such centers.
     *  why there are 2n - 1 but not n centers? The reason is the center of a palindrome can be in between two letters.
     *  Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
     * </p>
     * TIME COMPLEXITY: O(N^2)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public String longestPalindromeBetter(String s) {
        if (s == null || s.length() == 0) return "";

        int len = 1;
        int right = 0; // I use right and len here is it is a little hard for me to compute the left and right fr
        for (int i = 0; i < s.length(); i++) {
            int l1 = expandAroundCenter(s, i, i);
            int l2 = expandAroundCenter(s, i, i + 1);
            int max = Math.max(l1, l2);
            if (len < max) {
                len = max;
                right = i + max / 2;
            }
        }
        return s.substring(right + 1 - len, right + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}

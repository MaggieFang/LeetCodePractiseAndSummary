package com.oscar;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/21/19
 * Talk is Cheap,Show me the Code.
 **/
public class InterleaveString97H {
    /**
     * KEYPOINTS:
     * <p>
     * 状态cache[i][j]表示，s1的前i个字符和s2的前j个字符是否能交叉构成s3的前i+j个字符
     * 初始化：
     * cache[0][0] = True 因为两个空字符串可以组成空字符串
     * 递推关系 cache[i][j] = (s1[i-1] == s3[i+j-1] && cache[i-1][j]) ||  (s2[j-1] == s3[i+j-1] && cache[i][j-1])
     * <p>
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        boolean[][] memo = new boolean[n1 + 1][n2 + 1];
        memo[0][0] = true;

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = true;
                } else if (i > 0 && j > 0) {
                    memo[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && memo[i - 1][j]) ||
                            (s2.charAt(j - 1) == s3.charAt(i + j - 1) && memo[i][j - 1]);
                } else if (i == 0) {
                    memo[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) && memo[i][j - 1];
                } else if (j == 0) {
                    memo[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && memo[i - 1][j];
                }

            }
        }
        return memo[n1][n2];
    }

    /**
     * KEYPOINTS:
     * <p>
     * brute force
     * s1="abc"
     * s2="bcd"
     * s3="abcbdc"
     * Firstly we choose 'a' of s1s1 as the processed part pre, and call the recursive function considering
     * the new strings as s1s1="bc", s2s2="bcd", s3s3="abcbdc". When this function returns a result,
     * we again call the recursive function but with the new strings as s1s1="abc", s2s2="cd", s3s3="abcbdc"
     * </p>
     * TIME COMPLEXITY: O(2^(m+n))
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public boolean isInterleaveBruteFore(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1, 0, s2, 0, "", s3);

    }

    public boolean isInterleave(String s1, int i, String s2, int j, String pre, String s3) {
        if (pre.equals(s3) && i == s1.length() && j == s2.length()) {
            return true;
        }

        boolean ans = false;
        if (i < s1.length()) { //improve  if(i < s1.length() && s1.charAt(i) == s3.charAt(pre.length())){ 不一样就不需要进
            ans |= isInterleave(s1, i + 1, s2, j, pre + s1.charAt(i), s3);
        }

        if (j < s2.length()) {
            ans |= isInterleave(s1, i, s2, j + 1, pre + s2.charAt(j), s3);
        }
        return ans;
    }
}

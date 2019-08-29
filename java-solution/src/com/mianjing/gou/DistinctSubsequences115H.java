package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/13/19
 * Talk is Cheap,Show me the Code.
 **/
public class DistinctSubsequences115H {
    /**
     * KEYPOINTS:
     * <p>
     * when come into string matching problem.  most of them are solved by dp. when involved in two string, it always should be a two-dimensional array
     * we make dp[i][j] means the numbers that S[0, i-1] are matched with T[0, j-1];
     * for initial status, if T is empty, then always one way to match a empty string so T[i][0] = 1; and if S is empty then T[0][i] = 0;
     * for convert function.
     * if S[i- 1] == T[j - 1] , dp[i][j] = dp[i-1][j-1] + dp[i-1][j], first part means we match s[i-1] with t[j-1]
     * the second part means the ways that we can match T[0,j-1] without s[i-1] included.
     * if S[i -1] != T[j- 1], then dp[i][j] = dp[i-1][j]
     * </p>
     * TIME COMPLEXITY: O(n*m)
     * <p>
     * SPACE COMPLEXITY: O(n*m)
     * <p>
     **/
    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[slen + 1][tlen + 1];
        for(int i = 0; i <=slen; i++){
            dp[i][0] = 1;
        }

        for(int i = 0; i <= tlen; i++){
            dp[0][i] = 0;
        }
        dp[0][0] =1;
        for(int i = 1; i <= slen; i++){
            for(int j = 1; j <= tlen; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i- 1][j];
                }

            }
        }
        return dp[slen][tlen];

    }
}

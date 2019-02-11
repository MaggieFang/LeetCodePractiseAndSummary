package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/13/19
 * Talk is Cheap,Show me the Code.
 **/
public class DistinctSubsequences115H {
    /**
     * KEYPOINTS:
     * <p>
     * we will build an array mem where mem[i+1][j+1] means the number of ways S[0..j] contains T[0..i]
     * the result will be mem[T.length()][S.length()].
     * for M[i+1][j+1]:
     * if S[j] != T[i] we ignore S[j] so M[i+1][j+1] = M[i+1][j]
     * if S[j] == T[i] case 1, we mathc S[j] with T[i], so M[i+1][j+1] = M[i][j]; case 2,we ignore S[j]
     * so the total M[i+1][j+1] = M[i][j]+  M[i+1][j];
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0) {
            return 0;
        }
        if (m == 0) {
            return 1;
        }

        int[][] M = new int[m + 1][n + 1];// M[i+1][j+1]: means the number of ways S[0...j] contains T[0..i];

        for (int i = 0; i <= n; i++) {
            M[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) != t.charAt(i)) {
                    M[i + 1][j + 1] = M[i + 1][j];
                } else {
                    M[i + 1][j + 1] = M[i][j] + M[i + 1][j];
                }
            }
        }
        return M[m][n];
    }
}

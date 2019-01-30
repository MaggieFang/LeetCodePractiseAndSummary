package com.mianjing.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/12/19
 * Talk is Cheap,Show me the Code.
 **/
public class WaysToFormStrByRemove {
    //https://www.geeksforgeeks.org/ways-transforming-one-string-removing-0-characters/

    /**
     * KEYPOINTS:
     * The idea to solve this problem is using Dynamic Programming. Construct a 2D DP matrix of m*n size,
     * where m is size of string B and n is size of string A.
     * dp[i][j] gives the number of ways of transforming string A[0…j] to B[0…i].
     * Case 1 : dp[0][j] = 1, since placing B = “” with any substring of A would have only 1 solution which is to delete all characters in A.
     * Case 2 : when i > 0, dp[i][j] can be derived by two cases:
     * Case 2.a : if B[i] != A[j], then the solution would be to ignore the character A[j] and align substring B[0..i] with A[0..(j-1)].
     * Therefore, dp[i][j] = dp[i][j-1].
     * Case 2.b : if B[i] == A[j], then first we could have the solution in case a), but also we could match the characters B[i] and A[j]
     * and place the rest of them (i.e. B[0..(i-1)] and A[0..(j-1)]. As a result, dp[i][j] = dp[i][j-1] + dp[i-1][j-1].
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int waysToform(char[] a, char[] b) { // A to form B
        int n = a.length;
        int m = b.length;
        if (m == 0) return 1;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            //travel all character if a[] for b[i]
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    if (a[j] == b[i] && j == 0)
                        dp[i][j] = 1;
                    else if (a[j] == b[i])
                        dp[i][j] = dp[i][j - 1] + 1;
                    else
                        dp[i][j] = dp[i][j - 1];
                }

                // Filling other rows.
                else {
                    if (a[j] == b[i])
                        dp[i][j] = dp[i][j - 1] +
                                dp[i - 1][j - 1];
                    else
                        dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}

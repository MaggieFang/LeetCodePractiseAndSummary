package com.mianjing.fb;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class CoinChangeOrFootballScore {
    static long countWays(int S[], int n) {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        // it is good.we don't need to compute from 0 to n, just compute that can be sum of the existing items of S[]
        int m = S.length;
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];

        return table[n];
    }

    /**
     * KEYPOINTS:
     * <p>
     * Consider a game where a player can score 3 or 5 or 10 points in a move.
     * Given a total score n, find number of ways to reach the given score.
     * First put 3 at first position and recursively call for n-3.
     * Then put 5 at first position and recursively call for n-5.
     * Then put 10 at first position and recursively call for n-10.
     * If n becomes 0 then we have formed a combination that compose n, so print the current combination.
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
    static int count(int n) {
        // table[i] will store count of solutions for
        // value i.
        int table[] = new int[n + 1], i;

        // Initialize all table values as 0
        Arrays.fill(table, 0);

        // Base case (If given value is 0)
        table[0] = 1;

        // One by one consider given 3
        // moves and update the table[]
        // values after the index greater
        // than or equal to the value of
        // the picked move
        for (i = 3; i <= n; i++)
            table[i] += table[i - 3];
        for (i = 5; i <= n; i++)
            table[i] += table[i - 5];
        for (i = 10; i <= n; i++)
            table[i] += table[i - 10];

        return table[n];
    }

    //2，3，6，1,但是在6后才可能再得个1。
    static int football(int n) {
        int memo[] = new int[n + 1];
        Arrays.fill(memo, 0);
        memo[0] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] += memo[i - 2];
        }

        for (int i = 3; i <= n; i++) {
            memo[i] += memo[i - 3];
        }

        for (int i = 6; i <= n; i++) {
            memo[i] += memo[i - 6];
        }

        for (int i = 7; i <= n; i++) {
            memo[i] += memo[i - 7];
        }
        return memo[n];
    }

    /**
     * KEYPOINTS:
     * <p> baseball
     * At first position we can have three numbers 1 or 2 or 3.
     * First put 1 at first position and recursively call for n-1.
     * Then put 2 at first position and recursively call for n-2.
     * Then put 3 at first position and recursively call for n-3.
     * If n becomes 0 then we have formed a combination that compose n, so print the current combination.
     * <p>
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

    // Function prints all combinations of numbers 1, 2, ...MAX_POINT
    // that sum up to n.
    // i is used in recursion keep track of index in arr[] where next
    // element is to be added. Initital value of i must be passed as 0
    static void printCompositions(int arr[], int n, int i) {
        int MAX_POINT = 3;
        if (n == 0) {
            printArray(arr, i);
        } else if (n > 0) {
            for (int k = 1; k <= MAX_POINT; k++) {
                arr[i] = k;
                printCompositions(arr, n - k, i + 1);
            }
        }
    }

    // Utility function to print array arr[]
    static void printArray(int arr[], int m) {
        for (int i = 0; i < m; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

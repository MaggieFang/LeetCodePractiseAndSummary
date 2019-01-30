package com.dp;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/5/19
 * Talk is Cheap,Show me the Code.
 **/
public class fib {

    public int fibBottomUp(int n) {
        if (n == 0) return 0;
        int[] cache = new int[n + 1];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }


    /**
     * KEYPOINTS:
     * <p>
     *    fib(n-1) and fib(n-2) are the sub, so can cache their result to reuse.
     *    for f(n),we compute fib value for each value from 1 to n exactly once. give O(n) times
     *    but we O(n) space
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int fibTopDown(int n) {
        if (n < 2) return n;
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return fibTopDown(n, cache);
    }

    private int fibTopDown(int n, int[] cache) {
        if (cache[n] >= 0) return cache[n];
        cache[n] = fibTopDown(n - 1, cache) + fibTopDown(n - 2, cache);
        return cache[n];
    }

    /**
     * KEYPOINTS:
     * <p>
     * 画二分树图    fib(4)
     * /     \
     * f(3)   f(2)
     * /  \    /  \
     * f(2) f(1) f(1) f(1)
     * /  \
     * f(1) f(1)
     * we recursively call with n-1 each time and results in two more calls utils reach the base case
     * 1+2+4+8+.. +2^(n-1)  calls O(2^n)
     * </p>
     * TIME COMPLEXITY: O(2^n)
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }


}

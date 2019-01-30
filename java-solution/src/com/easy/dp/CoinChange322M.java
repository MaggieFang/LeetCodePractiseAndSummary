package com.easy.dp;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/5/18
 * Talk is Cheap,Show me the Code.
 **/
public class CoinChange322M {
    /**
     * KEYPOINTS:
     * <p>
     * Question: 1) if no way to change it, what should we return? (-1), including amount == 0?
     * 2) if the coins null or length = 0 ? what should we return.
     * 3) the coins arrays sorted or not?
     * T(n) is the fewest number chages
     * so T(n)= min{coin(0) + T(n- coin[0]),coin(1) + T(n-coin[1])....
     * coin[coin.number-1]+T(n-coin[coin.number-1])}*
     * so we can calculate makeChange from 0 to c-1,it will be easy to compute make(c)
     * will use O(c) space and O(c*n) times
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
    public int coinChange(int[] coins, int c) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        if (c == 0) {
            return 0;
        }

        int[] cache = new int[c + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;

        for (int i = 1; i <= c; i++) {
            int min = Integer.MAX_VALUE - 1;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    min = Math.min(min, cache[i - coin]);
                }
            }
            cache[i] = min + 1;
        }
        return cache[c] == Integer.MAX_VALUE ? -1 : cache[c];

    }


}

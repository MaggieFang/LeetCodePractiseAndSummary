package com.oscar;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/21/19
 * Talk is Cheap,Show me the Code.
 **/
public class BuySellStockAtMostK188H {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        if (k > n / 2) {
            int t_ik0 = 0, t_ik1 = Integer.MIN_VALUE;
            for (int p : prices) {
                int old_t_ik0 = t_ik0;
                t_ik0 = Math.max(t_ik0, t_ik1 + p);
                t_ik1 = Math.max(t_ik1, old_t_ik0 - p);
            }
            return t_ik0;
        }

        int[] t_ik0 = new int[k + 1];
        int[] t_ik1 = new int[k + 1];
        Arrays.fill(t_ik1, Integer.MIN_VALUE);
        for (int p : prices) {
            for (int j = k; j > 0; j--) {
                t_ik0[j] = Math.max(t_ik0[j], t_ik1[j] + p);
                t_ik1[j] = Math.max(t_ik1[j], t_ik0[j - 1] - p);
            }
        }
        return t_ik0[k];
    }
}

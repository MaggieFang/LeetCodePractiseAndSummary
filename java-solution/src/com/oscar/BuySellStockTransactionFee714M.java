package com.oscar;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/21/19
 * Talk is Cheap,Show me the Code.
 **/
public class BuySellStockTransactionFee714M {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        long t_ik0 = 0, t_ik1 = Integer.MIN_VALUE;
        for (int p : prices) {
            long old_t_ik0 = t_ik0;
            t_ik0 = Math.max(t_ik0, t_ik1 + p - fee);
            t_ik1 = Math.max(t_ik1, old_t_ik0 - p);
        }
        return (int) t_ik0;
    }
}

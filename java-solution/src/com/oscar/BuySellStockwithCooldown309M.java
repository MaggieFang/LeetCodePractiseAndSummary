package com.oscar;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/21/19
 * Talk is Cheap,Show me the Code.
 **/
public class BuySellStockwithCooldown309M {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int t_ik0 = 0, t_ik1 = Integer.MIN_VALUE, t_ik0_pre = 0;
        for (int p : prices) {
            int old_t_ik0 = t_ik0;
            t_ik0 = Math.max(t_ik0, t_ik1 + p);
            t_ik1 = Math.max(t_ik1, t_ik0_pre - p);
            t_ik0_pre = old_t_ik0;
        }
        return t_ik0;
    }
}

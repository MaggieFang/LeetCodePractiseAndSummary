package com.oscar;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/21/19
 * Talk is Cheap,Show me the Code.
 **/
public class BSStockAtMostTwo123H {
    public int maxProfit(int[] prices) {
        int t_i20 = 0, t_i21= Integer.MIN_VALUE;
        int t_i10 = 0, t_i11 = Integer.MIN_VALUE;
        for(int p : prices){
            t_i20 = Math.max(t_i20,t_i21+p);
            t_i21 = Math.max(t_i21,t_i10 - p);
            t_i10 = Math.max(t_i10,t_i11 + p);
            t_i11 = Math.max(t_i11,-p);
        }
        return t_i20;
    }
}

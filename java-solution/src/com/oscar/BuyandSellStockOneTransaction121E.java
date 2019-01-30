package com.oscar;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/20/19
 * Talk is Cheap,Show me the Code.
 **/
public class BuyandSellStockOneTransaction121E {
    //简化版本
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        for (int p : prices) {
            min = Math.min(min, p);
            maxProfit = Math.max(maxProfit, p - min);
        }

        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0;
        int min = prices[0];
        int max = prices[0];
        for (int p : prices) {
            if (max < p) {
                max = p;
            }
            if (p < min) {
                min = p;
                max = p;
            }
            maxProfit = Math.max(maxProfit, max - min);
        }

        return maxProfit;
    }
}

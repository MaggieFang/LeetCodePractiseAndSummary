package com.oscar;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/5/18
 * Talk is Cheap,Show me the Code.
 **/
public class BSStockTimeManyTransaction122E {

    public static int maxProfit11(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int n = prices.length;
        int result = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            while(i < n && prices[i] < min){
                min = prices[i];
                i++;
            }

            while(i < n && prices[i] > max){
                max = prices[i];
                i++;
            }
            if(max != Integer.MIN_VALUE && min != Integer.MAX_VALUE){
                result += (max - min);
            }
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            i--;
        }
        return result;

    }

}

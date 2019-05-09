package com.amazon;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-22
 * Talk is cheap,show me the Code.
 **/
public class MinimumCostForTickets983M {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }

        int[] memo = new int[days[days.length - 1] + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        int pre = 0;

        for (int d : days) {
            int tmp = pre + 1;
            while (tmp < d) {
                memo[tmp++] = memo[pre];
            }

            pre = d;

            if (d - 1 >= 0 && memo[d - 1] != Integer.MAX_VALUE) {
                memo[d] = Math.min(memo[d], memo[d - 1] + costs[0]);
            }

            if (d - 7 >= 0 && memo[d - 7] != Integer.MAX_VALUE) {
                memo[d] = Math.min(memo[d], memo[d - 7] + costs[1]);
            }

            if (d - 30 >= 0 && memo[d - 30] != Integer.MAX_VALUE) {
                memo[d] = Math.min(memo[d], memo[d - 30] + costs[2]);
            }

            tmp = d-1;
            while (d > 0 && memo[d] < memo[tmp]){
                memo[tmp--] = memo[d];
            }


        }
        return memo[days[days.length - 1]];
    }


    public static void main(String[] args){
        MinimumCostForTickets983M t = new MinimumCostForTickets983M();
        System.out.printf(t.mincostTickets(new int[]{1,4,6,7,8,20},new int[]{7,2,15})+"");
    }
}

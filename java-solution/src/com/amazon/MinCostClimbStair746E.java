package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class MinCostClimbStair746E {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i =2; i < dp.length;i++){
            int cur = (i == cost.length)? 0:cost[i];

            dp[i] = Math.min(dp[i-2]+cur,dp[i-1]+cur);

        }
        return dp[dp.length -1];
    }
}

package com.oscar;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/21/19
 * Talk is Cheap,Show me the Code.
 **/
public class StockSummary {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
     * <p>
     * The most straightforward way would be looking at actions taken on the i-th day.
     * How many options do we have? The answer is three: buy, sell, rest. Which one should we take?
     * The answer is: we don't really know, but to find out which one is easy. We can try each option
     * and then choose the one that maximizes our profit
     * let T[i][k] be the maximum profit that could be gained at the end of the i-th day with at most k transactions.
     * so at end of i-th,we have 2 states,hold 1 stock or 0 stock
     * soT[i][k] should really be split into two: T[i][k][0] and T[i][k][1],
     * so at end of i-th day, if it is T[i][k][0],maybe we no stock at beginning and the action is rest.
     * maybe we have 1 stock and we sell it so T[i][k][0] = Math.max{T[i-1][k][0],T[i-1][k][1] + prices[i]}
     * at the end of i-th day, if it is T[i][k][1],maybe we have 1 stock before and the action is rest.
     * maybe we have no stock and buy it. so T[i][k][1] = Math.max{T[i-1][k][1],T[i-1][k-1][0] - p[i]}
     * T[i][0][0] = 0; and T[i][0][1] = Integer.MIN since if no transcation. it is impossible to have 1 stock.
     * So relation:
     * T[i][k][0] = max{T[i-1][k][0],T[i-1][k][1]+price[i]}
     * T[i][k][1] = amx{T[i-1][k][1],T[i-1][k-1][0] - price[i]}
     * base case : T[i][0][0] = 0;T[i][0][1] = Integer.MIN
     * <p>
     * <p>
     * Case 1: k = 1,
     * so T[i][1][0] = Max{T[i-1][1][0],T[i-1][k][1] + p}
     * T[i][1][1] = Max{T[i-1][k][1],T[i-1][0][0] - p} = Max{T[i-1][k][1],- p}
     * so we just need two varialbe t_i10 and t_i11 and finish it.
     * <p>
     * <p>
     * Case 2: k = infinity.
     * If k is positive infinity, then there isn't really any difference between k and k - 1,
     * which implies T[i-1][k-1][0] = T[i-1][k][0] and T[i-1][k-1][1] = T[i-1][k][1].
     * Therefore, we still have two unknown variables on each day: t_ik0, and t_ik1, and the recurrence relations say:
     * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
     * T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i]) = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
     * <p>
     * <p>
     * Case 3 : k = 2
     * T[i][2][0] = max(T[i-1][2][0], T[i-1][2][1] + prices[i])
     * T[i][2][1] = max(T[i-1][2][1], T[i-1][1][0] - prices[i])
     * T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
     * T[i][1][1] = max(T[i-1][1][1], -prices[i])
     * so we have 4 varible.t_i20,t_i21,t_i10,t_i11
     * <p>
     * <p>
     * Case 4: k is arbitrary
     * A profitable transaction takes at least two days (buy at one day and sell at the other).
     * If the length of the prices array is n, the maximum number of  transactions is n/2.
     * After that no profitable transaction is possible, which implies the maximum profit will stay the same.
     * Therefore if the given k, k > n/2, we can extend k to positive infinity and the problem is equivalent to Case 2;
     * otherwise we need
     * int[] t_ik0 = new int[k + 1];  int[] t_ik1 = new int[k + 1]; to store the max profit at at most k.
     * <p>
     * <p>
     * Case 5: k = +Infinity but with cooldown
     * cooldown mean when we sell it. we cannot buy new the next day. so a little change to
     * T[i][k][0] = max{T[i-1][k][0],T[i-1][k][1]+price[i]}
     * T[i][k][1] = amx{T[i-1][k][1],T[i-1][k-1][0] - price[i]}
     * to
     * T[i][k][0] = max{T[i-1][k][0],T[i-1][k][1]+price[i]}
     * T[i][k][1] = amx{T[i-1][k][1],T[i-2][k-1][0] - price[i]}
     * <p>
     * <p>
     * Case 6: k = +Infinity but with transaction fee
     * T[i][k][0] = max{T[i-1][k][0],T[i-1][k][1]+price[i] - fee}
     * T[i][k][1] = amx{T[i-1][k][1],T[i-1][k-1][0] - price[i]}
     **/
    public int maxProfitCase1One(int[] prices) {
        int T_i10 = 0, T_i11 = Integer.MIN_VALUE;

        for (int price : prices) {
            T_i10 = Math.max(T_i10, T_i11 + price);
            T_i11 = Math.max(T_i11, -price);
        }

        return T_i10;
    }

    public int maxProfitCase2Infinite(int[] prices) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return T_ik0;
    }

    public int maxProfitCase3AtMost2(int[] prices) {
        int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
        int T_i20 = 0, T_i21 = Integer.MIN_VALUE;

        for (int price : prices) {
            T_i20 = Math.max(T_i20, T_i21 + price);
            T_i21 = Math.max(T_i21, T_i10 - price);
            T_i10 = Math.max(T_i10, T_i11 + price);
            T_i11 = Math.max(T_i11, -price);
        }

        return T_i20;
    }

    public int maxProfitCase4(int k, int[] prices) {
        if (k > prices.length / 2) {
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
            for (int price : prices) {
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }

            return T_ik0;
        }

        int[] T_ik0 = new int[k + 1];
        int[] T_ik1 = new int[k + 1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
            }
        }

        return T_ik0[k];
    }

    public int maxProfitCase5CoolDown(int[] prices) {
        int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
            T_ik0_pre = T_ik0_old;
        }

        return T_ik0;
    }

    public int maxProfitCase6Fee(int[] prices, int fee) {
        long T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            long T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price - fee);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return (int) T_ik0;
    }

}

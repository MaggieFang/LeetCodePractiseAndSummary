package com.array;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/1/18
 * Talk is Cheap,Show me the Code.
 **/
public class BSStockTime127 {
    public static void main(String[] args) {
        int prices[] = new int[]{7, 1, 5, 3, 6, 4};
        int prices2[] = new int[]{7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices2));
    }


    /**
     * KEYPOINTS:
     * <p>
     * max(P[j]-P[i]),j > i;
     * 注意本题不需要我们找出i,j，所以理论一轮过去就可以找到max profit，
     * 只需要一个min标识最低的价格，tempProfit标识当前跟min的差值，MaxProfit表示过程最大的profit即可
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *      min = IntegerMax;
     *      maxProfit = 0;
     *      for i = 1 to n:
     *          if min > P[i]:
     *              min = P[i]
     *          else if p[i] - min > maxProfit:
     *              maxProfit = p[i] - min;
     *
     *      return maxProft
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: 遍历，O[n]
     * <p>
     * SPACE COMPLEXITY: O[1]
     * <p>
     */
    public static int maxProfit(int prices[]) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int p : prices) {
            if (minPrice > p) {
                minPrice = p;
            } else {
                int tempProfit = p - minPrice;
                if (tempProfit > maxProfit) {
                    maxProfit = tempProfit;
                }
            }
        }
        return maxProfit;
    }
}

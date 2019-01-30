package com.dp;

import java.util.HashMap;
import java.util.Iterator;


/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/5/19
 * Talk is Cheap,Show me the Code.
 **/
public class Knapsack {
        /**
         * KEYPOINTS:
         * when i and w !=0 we can get result by looking the prior subproblem. i tells us which item to consider and
         * W tells us the remaining weight. we can get the vaule of excluding the item by looking W =W and i = i-1.
         * and get the value including it at W = W - item.weight and i -1
         * </p>
         * TIME COMPLEXITY: O(n*W)
         * <p>
         * SPACE COMPLEXITY:O(n*W)
         * <p>
         **/
    public int knapsackTopDownBottomUp(Item[] items, int W) {
        int[][] cache = new int[items.length + 1][W + 1];
        for (int i = 1; i < items.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (items[i - 1].weight > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i - 1][j - items[i - 1].weight] + items[i - i].value);
                }
            }
        }
        return cache[items.length][W];
    }

    /**
     * KEYPOINTS:
     * our function include a list of items. a wweight, and index.With each recursive call,
     * we either subtract our current item weight from the total weight or skip it.
     * therefore, the weight we pass in function is the remainling available weight . the index is the left items.
     * So, our recursive is asking, what is vthe max value of the items from i to item.length that weight less than given weight.
     * and initial with (item,W,0).
     * we  cache  using HashMap<Index,HashMap<W,Value>>
     * <p>
     * </p>
     * TIME COMPLEXITY:O(n*w) n number if itesm,since our worst case is that we will need to store
     * the subproblem for every weight< w,abd every item index.
     * <p>
     * SPACE COMPLEXITY: O(n*w)
     * <p>
     **/

    public int knapsackTopDown(Item[] items, int W) {
        HashMap<Integer, HashMap<Integer, Integer>> cache = new HashMap<>();
        return knapsackTopDown(items, W, 0, cache);
    }

    private int knapsackTopDown(Item[] items, int w, int i, HashMap<Integer, HashMap<Integer, Integer>> cache) {
        if (i == items.length) return 0;
        if (!cache.containsKey(i)) cache.put(i, new HashMap<Integer, Integer>());
        Integer value = cache.get(i).get(w);
        if (value != null) return value;
        int toReturn;
        if (w - items[i].weight < 0) {
            toReturn = knapsackTopDown(items, w, i + 1, cache);
        } else {
            toReturn = Math.max(knapsackTopDown(items, w - items[i].weight, i + 1, cache) + items[i].value,
                    knapsackTopDown(items, w, i + 1, cache));
        }
        cache.get(i).put(w, toReturn);
        return toReturn;

    }

    /**
     * KEYPOINTS:
     * <p>
     * </p>
     * TIME COMPLEXITY:O(2^n)
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int knapsack(Item[] items, int w) {
        return knapsack(items, w, 0);
    }

    private int knapsack(Item[] items, int w, int i) {
        // if go through all items, return
        if (i == items.length) return 0;
        // if the item too big to fill, skip
        if (w - items[i].weight < 0) {
            return knapsack(items, w, i + 1);
        }
        //find the max of including and excluding  the current item.
        return Math.max(knapsack(items, w - items[i].weight, i + 1) + items[i].value, knapsack(items, w, i + i));

    }

    static class Item {
        int weight;
        int value;
    }

}

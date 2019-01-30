package com.google;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class FruitIntoBaskets904M {
    /**
     * KEYPOINTS:
     * <p>
     * slide window
     * use a map to count the element.
     * when the map.size > 2. then use a while to move forward the start index. How?
     * decrease the count of tree[start], if the count == 0,so remove it from map. to find the new start
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n*k) // k is the size of map, here is 2
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
     **/
    public int totalFruit(int[] tree) {
        int ans = 0;
        if (tree == null) {
            return 0;
        }
        int max = 0;
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            while (map.size() > 2) {
                int tmp = map.get(tree[start]) - 1;
                map.put(tree[start], tmp);
                if (tmp == 0) {
                    map.remove(tree[start]);
                }
                start++;
            }
            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}

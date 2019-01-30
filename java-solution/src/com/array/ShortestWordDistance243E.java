package com.array;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/8/18
 * Talk is Cheap,Show me the Code.
 **/
public class ShortestWordDistance243E {
    /**
     * KEYPOINTS:
     * <p>
     * we can just use two indice point to the most currenctly w1 and w2,
     * Each time we find a new occurrence of one of the words, we do not need to search the entire array
     * for the other word, since we already have the index of its most recent occurrence.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
    **/
    public int shortestDistance(String[] ws, String w1, String w2) {
        int i1 = -1;
        int i2 = -1;
        int ans = ws.length;
        for (int i = 0; i < ws.length; i++) {
            if (ws[i].equals(w1)) {
                i1 = i;
            } else if (ws[i].equals(w2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                ans = Math.min(Math.abs(i1 - i2), ans);
            }
        }
        return ans;
    }

}

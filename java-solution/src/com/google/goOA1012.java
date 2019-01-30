package com.google;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/14/18
 * Talk is Cheap,Show me the Code.
 **/
public class goOA1012 {
    public int[] findParent(int[] nodes, int N) {
        if (nodes == null || nodes.length == 0) {
            return new int[0];
        }
        int[] result = new int[nodes.length];
        int p;
        for (int i = 0; i < nodes.length; i++) {
            p =nodes[i];
            int j = 0;
            while (j < N) {
                if (p < 0 || p > nodes.length) {
                    p = -1;
                    break;
                }
                p = nodes[p];
                j++;
            }
            result[i] = p;
        }
        return result;
    }

    public int[] shortestDistance(int[] home, int[] store) {
        if (home == null || home.length == 0) {
            return new int[0];
        }

        int[] result = new int[home.length];
        if (store == null || store.length == 0) {
            return result;
        }

        Arrays.sort(store);
        for (int i = 0; i < home.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < store.length; j++) {
                int tmp = Math.abs(home[i] - store[j]);
                if (min > tmp) {
                    index = j;
                    min = tmp;
                }
            }
            result[i] = store[index];
        }
        return result;
    }
}

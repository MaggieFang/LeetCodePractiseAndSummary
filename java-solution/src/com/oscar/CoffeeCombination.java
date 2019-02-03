package com.oscar;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/19/19
 * Talk is Cheap,Show me the Code.
 **/
public class CoffeeCombination {
    /**
     * 就是问给一个咖啡机 上面有 3 7 11 三个button 代表可以做成咖啡的容量
     * 然后用户这边给出一个min和max 问用3个button的combination 是否可以满足用户的需要
     * coinchange 变形
     */
    public boolean change(int[] btn, int min, int max) {
        int[] m = new int[max + 1];
        Arrays.fill(m, Integer.MAX_VALUE);
        m[0] = 0;
        for (int i = 1; i <= max; i++) {
            int cur = Integer.MAX_VALUE;
            for (int b : btn) {
                if (i - b >= 0) {
                    cur = Math.min(cur, m[i - b]);
                }
            }
            if (cur != Integer.MAX_VALUE) {
                m[i] = cur + 1;
                if (i >= min) return true;
            }

        }
        return false;
    }
}

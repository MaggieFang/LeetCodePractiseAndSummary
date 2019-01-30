package com.easy.hashtable;

import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class HappyNumber202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int newN = 0;
            while (n != 0) {
                int tmp = n % 10;
                newN += tmp * tmp;
                n = n / 10;
            }
            if (newN == 1) {
                return true;
            }
            n = newN;

        }
        return false;
    }
}

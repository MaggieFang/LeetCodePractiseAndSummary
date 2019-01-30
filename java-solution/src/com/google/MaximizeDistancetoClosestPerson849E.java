package com.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/30/18
 * Talk is Cheap,Show me the Code.
 **/
public class MaximizeDistancetoClosestPerson849E {
    /**
     * find the longest contiouns 0  (start,end)
     * if(start== 0){ sit in start}
     * if(end == 0){sit end}
     * else sit mid, if there are k contious 0, the ans is (K+1)/2
     * [1,0,0,0,0,1,0,1]
     **/
    public int maxDistToClosest(int[] seats) {
        int max = -1;
        int start = 0;
        int i = 0;
        while (i < seats.length) {
            start = i;
            while (start < seats.length && seats[start] == 1) {
                start++;
            }
            i = start + 1;
            while (i < seats.length && seats[i] == 0) {
                i++;
            }
            if (i == seats.length || start == 0) {
                max = Math.max(max, i - start);
            } else {
                max = Math.max(max, (i - start + 1) >> 1);
            }
        }
        return max;
    }
}

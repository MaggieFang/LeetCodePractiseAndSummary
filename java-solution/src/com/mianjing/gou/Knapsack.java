package com.mianjing.gou;

import com.coinbase.Flatten2Dto1D;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-12
 * Talk is cheap,show me the Code.
 **/
public class Knapsack {
    //有一些物体，物体有重量和价值两个数值，重量是1或者2。给定篮子的重量限制，问怎么取可以价值最大但是不超过篮子的限制重量。需要return物体的重量，价值pair。
    // 拿的物体个数不限

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * greedy
     * 将所有的物品按单位重量价值从大到小排序，然后按这个顺序放入背包。如果放完某个物品后：
     * 1. 背包恰好装满：这个解一定是最优解。因为背包中已不可再加入其他物体，而把背包中任何物体取出替换为其他物体的话，都会导致背包总价值降低。
     * 2. 背包容量剩1，但未放的物品全都是重量为2的：这个解还不一定是最优解，因为背包中虽然不可再加入物体，但是把目前背包中价值最低的1替换为背包外单位价值最高的2，
     * 有可能导致背包价值进一步增加。如果该替换能够进行，而且确实导致背包价值进一步增加，那么替换后的解一定是最优解；否则替换前的解为最优。
     * 例如放在里边的有个重量1，val 3的，外面有个重量2，value 4的，那么我们换掉 (1,3)这个
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int[] getMax(int[] weight, int[] value, int max) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); // assume the unit value is integer
        for (int i = 0; i < weight.length; i++) {
            map.put(value[i] / weight[i], i);
        }
        int totalValue = 0;
        int totalWeight = 0;
        int lastOne = -1;
        int maxTwoOut = -1;
        for (Integer key : map.descendingKeySet()) {
            int idx = map.get(key);
            if (max - totalWeight >= weight[idx]) {
                totalValue += value[idx];
                totalWeight += weight[idx];
                if (weight[idx] == 1) {
                    lastOne = idx;
                }
            } else if (max == totalWeight) {
                return new int[]{totalValue, totalWeight};
            } else if (maxTwoOut == -1 && weight[idx] == 2) {
                maxTwoOut = idx;
            }
        }
        //when comes here ,the left weight is 1 and all package left is weighted 2
        if (lastOne != -1 && maxTwoOut != -1) {
            if (value[lastOne] < value[maxTwoOut]) {
                totalValue -= value[lastOne];
                totalValue += value[maxTwoOut];
                totalWeight -= weight[lastOne];
                totalWeight += weight[maxTwoOut];
            }
        }
        return new int[]{totalValue, totalWeight};
    }
}

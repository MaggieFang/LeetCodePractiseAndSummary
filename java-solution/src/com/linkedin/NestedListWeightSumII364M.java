package com.linkedin;

import com.basic.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-07
 **/
public class NestedListWeightSumII364M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * This the very similar with NestedWeightSum339M. but the depth is increase from leaf to root.
     * So we can use the same method with NestedWeightSum339M but we need to record the level from root to leaf of each element.
     * we can use a int[][] record, to record the number at each level.
     * e.g [[1,1],2,[1,1]]: record[0]= {2}, record[1] = {1,1,1,1}, and the final result = (sum of record[i])* (recordSize - i)
     * [1,[4,[6]]]： record[0] = 1, record[1] = 4, record[3] = 6, result is 1*3+
     * so since we just need to know the sum of each level, we reduce the two dimention into one. newRecord[i] mean the sum of number at i level.
     *
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:O(n)
     * </p>
     **/
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        sum(nestedList, 0, list);
        int ans = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ans += list.get(i) * (size - i);
        }
        return ans;
    }

    public void sum(List<NestedInteger> list, int level, List<Integer> res) {
        for (int i = res.size(); i <= level; i++) { // it means if level >= res.size(),we need to expand res. otherwise, we res.get(level) will throw exception
            res.add(0);
        }
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                res.set(level, res.get(level) + ni.getInteger());
            } else {
                sum(ni.getList(), level + 1, res);
            }
        }
    }
}

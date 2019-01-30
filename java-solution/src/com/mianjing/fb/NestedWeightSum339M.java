package com.mianjing.fb;

import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class NestedWeightSum339M {

    int ans = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            sum(ni, 1);
        }
        return ans;
    }

    public void sum(NestedInteger item, int level) {
        if (item.isInteger()) {
            ans += item.getInteger() * level;
        } else {
            List<NestedInteger> list = item.getList();
            for (NestedInteger ni : list) {
                sum(ni, level + 1);
            }
        }
    }

    public static interface NestedInteger {
        // Constructor initializes an empty nested list.
//        public NestedInteger();

        // Constructor initializes a single integer.
//        public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();

    }
}

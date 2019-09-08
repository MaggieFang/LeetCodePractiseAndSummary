package com.linkedin;

import com.basic.NestedInteger;

import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class NestedWeightSum339M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * a recur one. init with level 1, when meet an interger, add num*level to result. else, recur call with level+1
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    int ans = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        sum(nestedList, 1);
        return ans;
    }

    public void sum(List<NestedInteger> list, int level) {
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                ans += ni.getInteger() * level;
            } else {
                sum(ni.getList(), level + 1);
            }
        }
    }
}

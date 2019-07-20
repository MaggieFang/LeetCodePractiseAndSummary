package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-07-20
 **/
public class CombinationSum39M {

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * a typical backtracking problem. for a element, it can be selected or skipped. two cases need excute at the same time not if else.
     * if selected, the next looking element still itself and the target will deduct it.
     * when skip,the next looking element is the next one and the target still the same.
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> r = new ArrayList<>();
        helper(candidates, target, 0, r, new ArrayList<>());
        return r;
    }

    public void helper(int[] candidate, int target, int index, List<List<Integer>> r, List<Integer> temp) {
        if (target == 0 && temp.size() != 0) {
            r.add(new ArrayList<>(temp));
            return;
        }
        if (index >= candidate.length) return;

        if (candidate[index] <= target) { //select candidate[index]
            temp.add(candidate[index]);
            helper(candidate, target - candidate[index], index, r, temp);// notice index here, not index+1 since it can be reuse.
            temp.remove(temp.size() - 1);  //remove when it return here. so we can go the next line that we don't select it.
        }

        helper(candidate, target, index + 1, r, temp); // skip candidate[index]
    }
}

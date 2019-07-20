package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-07-20
 **/
public class CombinationSumII40M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * the only difference from LC39 is that there maybe duplicate number in the candidates but should not include duplicate combination in the result
     * e.g  candidate=[ 1, 2,7,1], target = 8, the [1,7] and [7,1] are duplicate, should throw one away.
     * So we can fist sort the candidates, and in the backtracking, skip duplicate starting points
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> r = new ArrayList<>();
        helper(candidates, target, 0, r, new ArrayList<>());
        return r;
    }

    private void helper(int[] candidates, int target, int index, List<List<Integer>> r, List<Integer> temp) {
        if (target == 0 && temp.size() != 0) {
            r.add(new ArrayList<>(temp));
            return;
        }
        if (index >= candidates.length) return;
        if (candidates[index] <= target) {
            temp.add(candidates[index]);
            helper(candidates, target - candidates[index], index + 1, r, temp);
            temp.remove(temp.size() - 1);
        }
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }

        helper(candidates, target, index + 1, r, temp);
    }
}

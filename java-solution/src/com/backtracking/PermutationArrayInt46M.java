package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class PermutationArrayInt46M {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> i = new ArrayList<>();
        backtrack(list, i, nums);
        System.out.println(list);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * KEYPOINTS:
     * <p>
     * my solution
     * use boolean[] using = new boolean[nums.length]; to indicate the number are chosen.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        boolean[] using = new boolean[nums.length];
        backtrack(list, new ArrayList<Integer>(), nums, using);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] using) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (using[i]) {
                    continue;
                }
                using[i] = true;
                // if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, using);
                using[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] rags) {
        int[] A = new int[]{1, 2, 3};
        permute(A);
    }
}


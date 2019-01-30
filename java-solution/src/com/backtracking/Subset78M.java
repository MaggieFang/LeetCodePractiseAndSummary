package com.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class Subset78M {
    /**
     * KEYPOINTS:
     * <p>
     *
     *    subset is ignore the order
     *    input [1,2,3]
     *
     *    s0: begin []
     *    s1: so we can find that the set contains 1;
     *       get [1]
     *           [1,2]
     *           [1,2,3]
     *           [1,3]
     *    s2: choose that begins contains 2(do not want 1 again,cuz we contains all conditions contains 1 in s1)
     *       [2]
     *       [2,3]
     *    S3: choose that begins contains 3(do not want 1 and 2)
     *       [3]
     *
     *    so the help method contains a param that indicate the start index;
     *    but for permutation problems. order should be consider. so every loop we begin from 0,but we just add boolean[] using
     *    to indicate the character we are using (we have chosen)
     *
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
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
        subsetHelper(nums,0,chosen,ans);

        return ans;

    }
    public static void subsetHelper(int[] nums,int s,List<Integer> chosen,List<List<Integer>> ans){
        ans.add(new ArrayList<>(chosen));
        for(int i = s; i < nums.length; i++){
            chosen.add(nums[i]);
            subsetHelper(nums,i+1,chosen,ans);
            chosen.remove(chosen.size() -1);
        }
    }
    public static void main(String[] ar){
        int[] A = new int[]{1,2,3};
        subsets(A);
    }
}

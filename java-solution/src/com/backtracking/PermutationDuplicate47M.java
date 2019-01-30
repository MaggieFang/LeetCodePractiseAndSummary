package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class PermutationDuplicate47M {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> i = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        permuteUtils(nums,i,ans,visited);
        return ans;

    }
    public static void permuteUtils(int[] nums,List<Integer> chosen, List<List<Integer>> ans,boolean[] used){
        if(chosen.size() == nums.length){
            ans.add(new ArrayList<>(chosen));
        } else{
            for(int i = 0; i< nums.length; i++){
                if(used[i] || (i > 0 && nums[i]== nums[i-1] && !used[i - 1])){
                    continue;
                }
                chosen.add(nums[i]);
                used[i] = true;
                permuteUtils(nums,chosen,ans,used);
                used[i] = false;
                chosen.remove(chosen.size() -1);
            }
        }
    }
    public static void main(String[] rag){
        int[] A = new int[]{1,1,2};
        permuteUnique(A);
    }
}

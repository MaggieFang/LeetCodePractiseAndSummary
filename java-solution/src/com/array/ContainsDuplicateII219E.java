package com.array;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/3/19
 * Talk is Cheap,Show me the Code.
 **/
public class ContainsDuplicateII219E {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) >= k){
                return true;
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}

package com.mianjing.kuola;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-09
 * Talk is cheap,show me the Code.
 **/
public class HouseRobberIICycle213M {
    /**
     * Clarification:
     * </p>
     * Keypoints:
     * *  LC 198的进阶，但依旧是DP，并且关系不变,但这道题第一个跟最后一个相连，那么rob[n-1]就要考虑下了。
     * *  1,如果最后一个一定不包含，则rob1[n-1]取rob1[n-2],而求rob1[0]~rob1[n-2]跟 198完全一样.
     * *  2,如果第一个一定不包含，那么后面随便，rob2[1]~rob2[n-1]跟198完全一样.
     * *  最后结果就是max(rob2[n-1],rob1[n-2]);
     * *
     * </p>
     * TIME COMPLEXITY:  O(n)
     * SPACE COMPLEXITY: O(n)
     * </p>
     **/
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int n = nums.length;
        int[] exclude = new int[n];//not rob the last one;
        exclude[0] = nums[0];
        exclude[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < n-1; i++){
            exclude[i] = Math.max(exclude[i-1],exclude[i-2]+nums[i]);
        }

        int[] include = new int[n];
        include[0] = 0;
        include[1]  = nums[1];
        for(int i = 2; i < n; i++){
            include[i] = Math.max(include[i-1],include[i-2]+nums[i]);
        }

        return Math.max(include[n-1],exclude[n-2]);
    }
}

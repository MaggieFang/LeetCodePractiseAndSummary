package com.array;

import java.util.HashMap;

public class DegreeOfArray697 {
  /** KEYPOINTS:
       * <p>
       *  we just need to save the left index and right index of the element with max freq.
       * </p>
       * PSEUDOCODE:
       * <pre>
       *  <code>
       * </code>
       * </pre>
       * TIME COMPLEXITY:
       * <p>
       * SPACE COMPLEXITY:
       * <p>
     **/
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer,Info> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            Info info =map.get(n);
            if(info == null){
                info = new Info(i);
                map.put(n,info);
            }
            info.right = i;
            info.freq++;


        }
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(Info info: map.values()){
            if(info.freq > max){
                ans = info.right - info.left + 1;
                max = info.freq;
            }else if(info.freq == max){
                ans = Math.min(ans,info.right - info.left + 1);
            }
        }
        return ans;


    }

    public class Info{
        public int left;
        public int right;
        public int freq;
        public Info(int left){
            this.left = left;
        }
    }
}

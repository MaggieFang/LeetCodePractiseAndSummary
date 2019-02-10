package com.mianjing.quora;

import java.util.*;
import java.util.Map.Entry;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-09
 * Talk is cheap,show me the Code.
 **/
public class MaxSumNumberNotContinuos {
    //给一串数字，要求输出没有连续数字的最大总和的子集，（不连续是指数值上不连续，位置无所谓）
    // 比如[1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4] . output 2+2+2+4+4+4+4 = 22
    //比如[1，1，1，1，2，2，2，2, 3，4，4，5，5，5] 结果是2+2+2+2+5+5+5 = 23
    /**
     * Clarification:
     * This question not clear. 1) are they sorted? 2) 给的数字一定是连续的吗，有没[1,1,1,3,3,4,8,8]类似？
     * 3) all non-negative?
     * </p>
     * Keypoints:
     *  这里解法assume数字是general的，不一定连续
     *  其实如果是unique的话，其实就是很简单的dp. dp[i] = max(dp[i-1],dp[i-2]+num[i]) if num[i] == num[i-1]+1, and dp[i] = dp[i-1]+nums[i] otherwise.
     *  但是元素有重复的话，就不能用dp[i-1],dp[i-2]这样来算。而需要保留pre这样的，但其实想想也可以把它转成类似unique,因为只要一个数选了，那么他出现了多次都会被选，
     *  所以可以对同个元素的直接求和，这样就转成unqiue啦,但要保留元素用于判断是否连续，如上面例子
     *  [1:4]
     *  [2:8]
     *  [3:3]
     *  [4:8]
     *  [5:15]
     *  这样就转化成unique了！
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/

     public int max(int[] num){
         Arrays.sort(num);
         HashMap<Integer,Integer> map = new HashMap<>();
         for(int n: num){
             map.put(n,map.getOrDefault(n,0)+n);
         }
         ArrayList<Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
         //Entry<Integer,Integer>[] list = (Entry<Integer, Integer>[]) map.entrySet().toArray();
         if(list.size() == 1){
             return list.get(0).getValue();
         }
         int[] dp = new int[list.size()];
         dp[0] = list.get(0).getValue();
         if(list.get(0).getKey() +1 == list.get(1).getKey()){
             dp[1] = Math.max(dp[0],list.get(1).getValue());
         }else {
             dp[1] = dp[0]+ list.get(1).getValue();
         }

         for(int i = 2; i < list.size();i++){
             if(list.get(i-1).getKey() +1 == list.get(i).getKey()){
                 dp[i] = Math.max(dp[i-1],dp[i-2]+ list.get(i).getValue());
             }else {
                 dp[i] =dp[i-1]+ list.get(i).getValue();
             }
         }
         return dp[list.size()-1];
     }
     public static void main(String[] args){
         MaxSumNumberNotContinuos t = new MaxSumNumberNotContinuos();
         int[] A = {1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4};
         int[] B = {1,1,1,1,2,2,2,2, 3,4,4,5,5,5};
         System.out.println(t.max(A));
         System.out.println(t.max(B));
     }
}

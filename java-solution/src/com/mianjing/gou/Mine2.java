package com.mianjing.gou;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/19/19
 * Talk is Cheap,Show me the Code.
 **/
public class Mine2 {
    //输入： array,找出all pairs,pair的和等于剩余元素的和
    //解法2用Map<Integer,Integer> 存放idea->A[i], idea+A[i] = sum/2
    private List<Pair<Integer,Integer>> findResult(int[] A){
        List<Pair<Integer,Integer>> ans = new ArrayList<>();
        if(A == null || A.length == 0) return ans;
        int sum = 0;
        for(int i : A){
            sum+= i;
        }

        for(int i = 0; i < A.length; i++){
            for(int j = i; j < A.length; j++){
                if((A[i]+A[j])*2 == sum){
                    ans.add(new Pair<>(A[i],A[j]));
                    //其实像[4,3,3,4]只输出(4,3)(3,4)的话，其实只要找到，这里就可以break内层循环了
                }
            }
        }
        return ans;
    }
}

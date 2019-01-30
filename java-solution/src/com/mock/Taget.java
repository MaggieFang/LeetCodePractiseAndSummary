package com.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/19/18
 * Talk is Cheap,Show me the Code.
 **/
public class Taget {
    static int[][] findPairsWithGivenDifferenceRight(int[] arr, int k) {
        if(arr == null || arr.length == 0){
            return new int[0][];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int x  : arr){
            map.put(x-k,x);
        }
        for(int y : arr){
            if(map.containsKey(y)){
                int[] item = new int[2];
                item[0]= map.get(y);
                item[1] = y;
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i = 0;i < ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    static int[][] findPairsWithGivenDifferenceWrong(int[] arr, int k) {
        if(arr == null || arr.length == 0){
            return new int[0][];
        }
        List<int[]> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length;i++){
            int cur = arr[i];
            if(map.containsKey(cur)){
                int[] a = new int[2];
                a[0] = cur;
                a[1] = map.get(cur);
                ans.add(a);
            }
            map.put(cur+k,cur);
        }
        map.clear();
        for(int i =0; i < arr.length; i++){
            int cur = arr[i];
            if(map.containsKey(cur)){
                int[] a = new int[2];
                a[1] = cur;
                a[0] = map.get(cur);
                ans.add(a);
            }
            map.put(cur-k,cur);
        }
        int[][] res = new int[ans.size()][];
        for(int i = 0; i < ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    public static void main(String[] args){
        int[] A = new int[]{4,1};
        System.out.println(findPairsWithGivenDifferenceRight(A,3).length);
    }

}

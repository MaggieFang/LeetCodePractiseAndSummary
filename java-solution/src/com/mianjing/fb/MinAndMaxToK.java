package com.mianjing.fb;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/14/18
 * Talk is Cheap,Show me the Code.
 **/
public class MinAndMaxToK {
    //For a given vector of integers and integer K, find the number of non-empty subsets S such that min(S) + max(S) <= K
    //For example, for K = 8 and vector [2, 4, 5, 7], the solution is 5 and these are all the subsets that satisfy the requirements: [2], [4], [2, 4], [2, 4, 5], [2, 5].

    // this is for contious item solution.But the problem's ans can include the separately ones
    public int find(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int min = A[i];
            if (min > K) {
                break;
            }
            int maxRequire = K - min;
            /**
             *  there is some problem [2,4,5,7],K = 8 we will miss [2,5] this condition
             *  so when we selected the min, we can there are how many max,and to find their combination.
             *  seen findSeperate(int[] ,int);
             */
            for (int j = i; j < A.length; j++) {

                if(A[j] <= maxRequire){
                    ans++;
                }
            }
        }
        return ans;
    }

    public int findSeperate(int[] A,int K){
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int min = A[i];
            if (min > K) {
                break;
            }
            int maxRequire = K - min;
            int count = 0;
            for (int j = i; j < A.length; j++) {
                if(A[j] <= maxRequire){
                   count++;
                }
            }
            //每一个都可以跟min组合，-1是减去他自身一定要存在的，其他的都是可以有可以没
            ans += Math.pow(2,count-1);

        }
        return ans;
    }



}

package com.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/6/18
 * Talk is Cheap,Show me the Code.
 **/
public class ThreeSum15M {
    /**
     * KEYPOINTS:
     * <p>
     * Q: Q: 1) A == null or A.lenth < 3?
     *    Brute force:   for i = 0 to n-3
                          for j = i to n-2
                             for k = j to n-1
     * get all the triplets of the array and check it during create it and put it into result.
     * improve: if the array is sorted. then it can be reduced to O(n^2)
     *         because we can do a loop  for i = 0 to n-3 and we store the v = 0 - num[i]
     *         and use two pointer low,hi to find the pair equals to v.
     *         notice that to filter the same item because the same A[i] will find the same result.
     *         e.g -1,-1,0,1,2, the {-1,0,1} has been found when  i = 0, so A[1]==A[0] the A[1] can be ignore.
     *
     *  <p>
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
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) { // to filter the same array. e.g -1,-1,0,1,2
                continue;
            }
            int low = i + 1, hi = num.length - 1;
            int sum = 0 - num[i];
            while (low < hi) {
                int v = num[low] + num[hi];
                if (v == sum) {
                    result.add(Arrays.asList(num[i], num[low], num[hi]));
                    low++;
                    hi--;
                    while (low < hi && num[low] == num[low - 1]) low++;
                    while (low < hi && num[hi] == num[hi + 1]) hi--;
                } else if (v < sum) {
                    low++;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }

    // will exceed time limit
    public List<List<Integer>> threeSumBruteForce(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= num.length -3; i++){
            if(i != 0 && num[i-1] == num[i]){
                continue;
            }
            for (int j = i+1; j <= num.length -2 ; j++) {
                if(j != i+1 && num[j-1] == num[j]){
                    continue;
                }
                for (int k = j+1; k <= num.length -1; k++) {
                    if(k != (j+1) && num[k] == num[k-1]){
                        continue;
                    }
                    if(num[i]+num[j]+num[k] == 0){
                        list.add(Arrays.asList(num[i],num[j],num[k]));
                    }
                }

            }
        }
        return list;
    }



    public static void main(String[] args) {
        int[] A = new int[]{-2, -1, 0, 1, 3, 8};
        int[] B = new int[]{-2, -2, 0, 2, 3};
        ThreeSum15M test = new ThreeSum15M();
        System.out.println(test.threeSum(A));
        System.out.println(test.threeSum(B));


    }
}

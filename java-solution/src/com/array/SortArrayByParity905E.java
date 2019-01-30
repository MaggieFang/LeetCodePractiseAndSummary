package com.array;

public class SortArrayByParity905E {
      /** KEYPOINTS:
           * <p>
           * i point  to the first odd number. and j from the i to find the first even number and exchange it.
           * repeat this process till to the end.
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
    public int[] sortArrayByParity(int[] A) {
        if(A == null || A.length == 0){
            return A;
        }
        int i = 0;
        int j = 0;
        while(true){
            while(i < A.length && A[i] % 2 == 0){
                i++;
            }
            j = i+1;
            while (j < A.length && A[j] % 2 == 1){
                j++;
            }
            if(i >= A.length || j >= A.length){
                break;
            }
            int tmp = A[j];
            A[j] = A[i];
            A[i] = tmp;
            i++;
        }
        return A;
    }
   // use new space
    public int[] sortArrayByParity2(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                ans[t++] = A[i];
            }
        }
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 1){
                ans[t++] = A[i];
            }
        }
        return ans;

    }
}


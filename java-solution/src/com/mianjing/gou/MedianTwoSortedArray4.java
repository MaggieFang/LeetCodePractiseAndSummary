package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/2/18
 * Talk is Cheap,Show me the Code.
 **/
public class MedianTwoSortedArray4 {
    /**
     len1 and len2 , total  = len1 + len2
     find the kth element,when k = total/2 when total is odd, and mean of kth and (k-1)th

     assume size of A and B both larger than k/2; and if we compare the k/2th element in A and k/2th element in B. get 3 results
     (1) A[k/2-1] = B[k/2-1]
     (2)           <
     (3)           >
     if(2), it means all elemnt from A[0] to A[k/2 -1] are in the range of kth of union of A and B.
     So A[k/2-1] never be larger than the kth elements . So we can drop the first k/2 part of A. similar ti (3),
     when (1) then it mean we found the kth, we call it m. there are each (k/2-1) numbes smaller than m in A and B.
     so m must be the the kth smallest in union of them.
     edge case:
     1. A or b is empty,return B[k-1](or A[k-1])
     2. when k == 1 and A,B not empty min(A[0],A[0])
     3. when A[k/2-1] == B[k/2-1] return it.

     **/
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        int t = num1.length + num2.length;
        int s1 = 0,s2 = 0;
        if(t % 2 == 0){
            return (median(num1,num2,s1,s2,t/2+1)+median(num1,num2,s1,s2,t/2))/2;
        }else{
            return median(num1,num2,s1,s2,t/2 +1 );
        }

    }

    public double median(int[] A,int[] B,int s1,int s2,int k){
        if(s1 >= A.length){
            return B[s2+k-1];
        }
        if(s2 >= B.length){
            return A[s1+k-1];
        }

        if(k == 1){
            return Math.min(A[s1],B[s2]);
        }



        int m1 = s1 + k/2-1;
        int m2 = s2 + k/2 -1;

        int mid1 = m1 < A.length? A[m1] :Integer.MAX_VALUE;
        int mid2 = m2 < B.length? B[m2]:Integer.MAX_VALUE;

        if(mid1 < mid2){
            return median(A,B,m1+1,s2,k-k/2);
        }else {
            return median(A,B,s1,m2+1,k - k/2);
        }
//        else{
//            return mid1;
//        }
    }
}

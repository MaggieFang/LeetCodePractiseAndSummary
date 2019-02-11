package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/7/19
 * Talk is Cheap,Show me the Code.
 **/
public class MedianofTwoSortedArraysSameSize {
    //from geekstogeeks https://www.geeksforgeeks.org/median-of-two-sorted-arrays/

    /**
     * KEYPOINTS:
     * <p>
     * 1. Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively.
     * 2. If m1 == m2 , then we are done. return m1 (or m2)
     * 3. If m1> m2, then median is present in : first element of ar1 to m1. from m2 to last element ar2
     * 4. If m2> m1, then median is present in :first elem of ar2 to m2. from m1 to last elem ar2
     * 5.Repeat the above process until size of both the subarrays becomes 2.
     * Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
     * </p>
     * TIME COMPLEXITY: log(n)
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
     **/
    public int median(int[] ar1, int[] ar2, int n) {
       return median(ar1,ar2,0,n-1,0,n-1);

    }

    public int median(int[] ar1, int[] ar2, int s1, int e1, int s2, int e2) {
       int len = e1 - s1 + 1;
       if(len == 1) return (ar1[s1] + ar2[s2])/2;
       if(len == 2) return (Math.max(ar1[s1],ar2[s2])+ Math.min(ar1[e1],ar1[e2]))/2;
       int m1 = calMedian(ar1,s1,e1);
       int m2 = calMedian(ar2,s2,e2);

       if(m1 == m2) return m1;

       if(m1 > m2){
           // median exist [.... m1] [m2....]
           if(len % 2 == 0){ // the two elem to cal m1 and m2 included, s1+len/2-1,s1+len/2
               return median(ar1,ar2,s1,s1+len/2,s2+len/2-1, e2);
           }
           return median(ar1,ar2,s1,s1+len/2,s2+len/2,e2);
       }else {
           //median exist[m1.....][...m2]
           if(len % 2 == 0){ // the two elem to cal m1 and m2 included, s1+len/2-1,s1+len/2
               return median(ar1,ar2,s1+len/2-1,e1,s2,e2+len/2);
           }
           return median(ar1,ar2,s1,s1+len/2,s2+len/2,e2);
       }
    }

    private int calMedian(int[] ar, int s, int e) {
        int len = e - s + 1;
        if(len % 2 == 0){
            return ar[s+len/2] + ar[s+len/2 -1];
        }
        return ar[s + len/2];
    }
}

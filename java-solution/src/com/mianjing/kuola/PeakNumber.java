package com.mianjing.kuola;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-08
 * Talk is cheap,show me the Code.
 **/
public class PeakNumber {
    /**
     * Clarification:
     * 1. if all elements are same? what return?
     * 2. is only 1 peak or more than 1,if more than one, we return the first one? or random one?
     * 3. are they sorted (decrease,increase)
     * 4. what about only 1,if the element is last or first. e.g [1,2], 2 is the result?
     * </p>
     * Keypoints:
     *     这种图画个图挺好的，跟stock那种，想想规律
     *     we can do a linear traversal to find the candidate. O(n).
     *     but We can use Divide and Conquer to find a peak in O(Logn) time. The idea is Binary Search based,
     *     compare middle element with its neighbors. If middle is not smaller than any of its neighbors, then we return it.(如果是要求返回first或者last，就先把mid作为candidate留着)
     *     If  middle element is smaller than left neighbor, then there is always a peak in left half (Why? take few examples).
     *     If  middle element is smaller than right neighbor, then there is always a peak in right half
     * </p>
     * TIME COMPLEXITY: O(logN)
     * SPACE COMPLEXITY:
     * </p>
    **/
    public int peak(int[] A) {
        int low = 0, high = A.length -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if((mid == 0 || A[mid] >= A[mid-1]) && (mid == A.length - 1 || A[mid] >=  A[mid+1])){
                return A[mid];
            }else if(mid > 0 && A[mid] < A[mid-1]){
                high  = mid -1;
            }else if(mid < A.length -1 && A[mid] < A[mid+1]){
                low = mid +1;
            }
        }
        return A[low];
    }

   public static void main(String[] args){
       int A1[] = {1, 3, 20, 4, 1, 0};
       int A2[] = {1, 2,3};
       int A3[] = {1};
       int A4[] = {3,2,1};
       int A5[] = {4,4,4,4};
       int A6[] = {1,2,3,8,3};  // right part
       int A7[] = {1,4,8,3,3,8,3}; // left part
       PeakNumber t = new PeakNumber();
       System.out.println(t.peak(A1));
       System.out.println(t.peak(A2));
       System.out.println(t.peak(A3));
       System.out.println(t.peak(A4));
       System.out.println(t.peak(A5));
       System.out.println(t.peak(A6));
       System.out.println(t.peak(A7));

   }
}

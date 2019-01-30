package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class TargetTimes {
    public static int find(int[] A,int target){
        int  low= 0;
        int hi = A.length-1;
        int l = -1,r = -1;
        while (low <= hi){
            int mid = low + (hi - low)/2;
            if(A[mid] > target){
                hi = mid -1;
            }else  if( A[mid] < target){
                low = mid + 1;
            }else {
                l = mid;
                hi = mid -1;
            }
        }
        low  = 0;
        hi = A.length - 1;
        while (low <= hi){
            int mid = low + (hi - low)/2;
            if(A[mid] > target){
                hi = mid -1;
            }else  if( A[mid] < target){
                low = mid + 1;
            }else {
                r = mid;
                low = mid + 1;
            }
        }
        System.out.println("r="+r+",l="+l);
        if(l == -1 && r == -1){
            return 0; // 没找到
        }
        return  r - l +1;
    }
    public static void main(String[] ag){
        int[] A = new int[]{1,2,3,3,3,3,3,3,3,4,5,6};
        int[] B = new int[]{3,3,3,3,3,3,3,3,3,3,3};
        int[] C = new int[]{3,3,3,3,3,3,5,9,13,23,33};
//        System.out.println(find(A,3) + ",size="+A.length);
//        System.out.println(find(B,3) + ",size="+B.length);
        System.out.println(find(C,8) + ",size="+C.length);
        System.out.println(find(B,0) + ",size="+B.length);
    }
}

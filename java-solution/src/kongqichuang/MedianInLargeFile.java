package kongqichuang;

import org.omg.CORBA.INTERNAL;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-03
 **/
public class MedianInLargeFile {
    private int findMedian(int[] nums){
        if(nums.length / 2 == 1){
            return findMedian(nums,Integer.MIN_VALUE, Integer.MAX_VALUE,nums.length/2+1); //  第几大意思
        }else {
            return (findMedian(nums,Integer.MIN_VALUE,Integer.MAX_VALUE,nums.length/2)
                    + findMedian(nums,Integer.MIN_VALUE,Integer.MAX_VALUE,nums.length/2+1))/2;
        }
    }

    private int findMedian(int[] nums,int left, int right, int k){
        if(left >= right) return left;
        int guess = left + (right - left)/2;
        int count = 0;
        int res = left;
        for(int num : nums){
            if(num <= guess){
                count++;
                res = Math.max(res,num);
            }
        }

        if(count == k){
            return res;
        }else if(count < k) {
            return findMedian(nums,Math.max(guess,res + 1), right,k);
        }else {
            return findMedian(nums,left,res,k);
        }
    }
}

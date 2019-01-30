package com.mianjing.fb;

import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class findTwoSingleNumber {
    //mutation of 136,now there are two single number in the array. find them.
    /**
     * KEYPOINTS:
     * <p>
     *  we know if there are one single number, we use XOR to get it.
     *  when there are two. XOR will be the two single numbers' XOR.
     *  we call it result here.
     *  so if the bit of result is 1. the two numbers in this bit must be different. one is 1 and the other is 0.
     *  if  the bit if the result is 0, the two numbers in this bit are same. both 0 or both 1.
     *
     *  if ith bit is 1, so the two numbers in this bit one is 1 and the other is 0.
     *  so we can divide the array into two parts.  one part is this bit is 0 and the other is 1.
     *  and the number we find will be one in one part,the other in the other part.
     *  and we know that if the two numbers are same. they will be divide into the same part.
     *  so the numbers in every part is same in pair except the one we find. So now we go to the LC136
     *
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
    public int[] findSingleNumber(int[] A){
        int result = 0;
        for(int a : A){
            result^= a;
        }
        //now result is the xOR of the two target number.

        int leastBit1 = (result & (result -1))^result;// n & (n-1) will change the least bit 1 to 0.the other bit is same with n, and then XOR n,we can get the least bit 1.and the other bit are 0.

        int groupA= 0, groupB = 0;
        for(int a: A){
            if((a & leastBit1) == 1){
                groupA ^= a;
            }else{
                groupB ^= a;
            }
        }
        return new int[]{groupA,groupB};
    }
}

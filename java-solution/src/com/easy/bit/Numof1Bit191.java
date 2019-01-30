package com.easy.bit;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/28/18
 * Talk is Cheap,Show me the Code.
 **/
public class Numof1Bit191 {
    public static void main(String[] arg){
        System.out.println(hammingWeight(2147483647));
    }

    // if we write in this way, when we input 2147483648, it will be translated into 100000...000 (-1),
    // 负数补码右移https://github.com/MaggieFang/leetcode/blob/master/java-knowlege/notes/some%20note%20of%20bit%20operation.md
    //!!! A wrong answer
    public static int hammingWeight(int n) {
        int result = 0;
        while( n > 0){
            if((n & 1) == 1) result++;
            n = n >> 1;
        }
        return result;
    }

    /**
     * KEYPOINTS:
     * <p>
     *     we make the mask to left shift every time to check the bit of n.
     *     so we can need to care about the n's negative or positive.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(1), it depends on the number of bits in n, bit it is still an int.
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
    **/
    public int hammingWeightMaskLeftMove(int n) {
        int result = 0;
        int mask = 1;
        for(int i =0; i < 32;i++){
            if((n & mask) !=0){
                result++;
            }
            mask <<= 1;
        }
        return result;
    }

    /**
     * KEYPOINTS:
     * <p>
     *      use trick AND-ing n and n-1flips the least-significant 1-bit to 0.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(1),depends on the number of 1-bits in n.
     * In the worst case, all bits in n are 1-bits. In case of a 32-bit integer, the run time is O(1)
     * <p>
     * SPACE COMPLEXITY:O(1)
     * <p>
    **/
    public int hammingWeightFlipLeastBit1(int n) {
        int count = 0;
        while(n != 0){
            n = n &(n-1);
            count++;
        }
        return count;
    }

}

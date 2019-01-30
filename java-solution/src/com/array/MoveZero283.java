package com.array;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/2/18
 * Talk is Cheap,Show me the Code.
 **/
public class MoveZero283 {
    public static void main(String[] args){
    }

    /**
     * KEYPOINTS:
     * <p>
     * 我们只需要将非0全部移一起则可，最后剩下的位置全部填写0；
     * 遍历过去，两个index，一个ready的，另一个遍历用的，遇到0跳过；非零复制到readyIndex位置，index往后
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *      int readyIndex = 0;
     *   for i= 1 to n:
     *     if A[i] != 0:
     *        A[readyIndex++] = A[i]
     *   while readyIndex < n:
     *        A[readyIndex] = 0
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY:O(1)
     * <p>
    **/
    public static void moveZeroes(int[] nums) {
        int readyIndex = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != 0){
                nums[readyIndex++] = nums[i];
            }
        }

        for (;readyIndex < nums.length;readyIndex++){
            nums[readyIndex] = 0;
        }
    }
}

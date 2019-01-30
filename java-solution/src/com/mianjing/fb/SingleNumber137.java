package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class SingleNumber137 {
    /**
     * KEYPOINTS:
     * <p>
     *     * 136，其他出现2次使用的是一直异或来解决的。看到这个的问题的时候，我们不禁会想，是否也有同样的方法来解决呢，
     * 什么情况下三个相同的数字才能消除呢，这样的想法很不幸，基本就走入了死胡同。
     * 所以有时我们需要换一个角度来思考问题，我们仍然从位运算来考虑。
     * 一个数从二进制的角度来看，无非就是0和1，若是我们只从各个位来看，就把这一位的内容加起来，除以3，剩余的余数应该就是单独剩下的这个数在这一位上的值。
     * 有了单独这个数在各个位的值，这一个剩下的数也就出来了。
     * 这样来看，我们需要一个大小为32的数组来保存这个数，这个空间并不会随着数组n值的增加而变化，所以从空间角度来看是没有问题的。
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
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        int[] count = new int[32];
        for(int i= 0; i < 32; i++){
            for(int n : nums){
                if(((n >> i) & 1) == 1){
                    count[i]++;
                }
            }
            result = result + ((count[i] % 3) << i);
        }
        return result;
    }
    /** solution 2
     * KEYPOINTS:
     * <p>
     *     from the above solution,we can see we just need to count the current bit .so take int count instead of count[32]
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

    public int singleNumber2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        int curBit = 0;
        for(int i= 0; i < 32; i++){
            curBit = 0;
            for(int n : nums){
                curBit += ((n >> i) &1);

            }
            result = result + ((curBit % 3) << i);
        }
        return result;
    }


}

package com.array;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class MissingNumber268 {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumberGauss(nums));


    }

    public static int missingNumber(int[] nums) {
        int[] temp = new int[nums.length + 1];
        for (int number : nums) {
            temp[number] = 1;

        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KEYPOINTS:
     * <p>
     *     这个想法是有问题的，处理A，跳到B，B再跳C。。。实际这样可能不能做一个完全的循环，例如{9,6,4,2,3,5,7,0,1},
     *     在处理0时候到了i=0的9，就又回到处理6情况了
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *      number[length] = -2;
     *      traverse the array,
     *      to save number[number[i]] temp, and set number[number[i]]= -1 indicating it was
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
//    public static int missingNumberOriginalArray(int[] nums) {
//        if (nums.length == 0) {
//            return -1;
//        }
//
//        if (nums.length == 1) {
//            if (nums[0] == 1) {
//                return 0;
//            } else {
//                return -1;
//            }
//        }
//        int number = nums[0];
//        int i = 0;
//        while (i < nums.length) {
//            if(number >= nums.length || number < 0){
//                ++i;
//                if(i < nums.length){
//                    number = nums[i];
//                    continue;
//                }else {
//                    break;
//                }
//            }
//            int temp = nums[number];
//            nums[number] = -1;
//            number = temp;
//            i++;
//        }
//
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != -1) {
//                return j;
//            }
//
//        }
//        return  -1;
//    }

    /**
     * KEYPOINTS:
     * <p>
     * using the rule XOR, a = a^b^b
     * there are number 0 - n, but there are only (n-1) 个.
     * so we init r = num.length to match the number n value
     * and XOR all index and value, the result is what is missing.
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
    public static int missingNumberOXR(int[] nums) {
        int r = nums.length;
        for (int i = 0; i < nums.length; i++) {
            r = r ^ i ^ nums[i];
        }
        return r;
    }

    /**
     * KEYPOINTS:
     * <p>
     * sum(0-n) = n(n+1)/2
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
    public static int missingNumberGauss(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) >> 1;
        int realSum = 0;
        for (int n : nums) {
            realSum += n;

        }
        return expectedSum - realSum;
    }
}

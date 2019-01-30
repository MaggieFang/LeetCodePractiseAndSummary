package com.array;

import java.util.ArrayList;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class PlusOne66 {
    public int[] plusOnePerfect(int[] digits) {
        for(int i = digits.length - 1; i>= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i]= 0;
        }

        int[] results = new int[digits.length+1];
        results[0] = 1;
        return results;

    }
    public static void main(String[] args) {
        int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] test2 = new int[]{9};
//        System.out.println(plusOne(test));
        System.out.println(plusOneHandleEachElement(test2));
    }

    /**
     * KEYPOINTS:
     * <p>
     * 不是个100%正确的方案，大数呢？
     * It is a direct idea, but it is not extendable.
     * what if the n length was beyond the long scope,the result is a large number?
     * so the safest way is to handle the  element one by one.
     * <p>
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
    public static int[] plusOne(int[] digits) {
        long number = 0;
        boolean allNine = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                allNine = false;
            }
            number += digits[i] * Math.pow(10, digits.length - i - 1);
        }
        ++number;

        int[] result;
        if (allNine) {
            result = new int[digits.length + 1];
        } else {
            result = new int[digits.length];
        }
        for (int i = 0; i < result.length; i++) {
            int divide = (int) (Math.pow(10, result.length - 1 - i));
            result[i] = (int) (number / divide);
            number = number % divide;
        }
        return result;
    }

    public static int[] plusOneHandleEachElement(int[] digits) {
        boolean allNine = true;
        for (int n : digits) {
            if (n != 9) {
                allNine = false;
                break;
            }
        }

        int size = digits.length;
        if (allNine) {
            ++size;
        }

        int[] result = new int[size];
        int plusOneHigher = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + plusOneHigher;
            if (i == digits.length - 1) {
                ++temp;
            }
            result[--size] = temp % 10;
            plusOneHigher = temp / 10;

        }

        if (allNine) {
            result[0] = 1;
        }

        return result;

    }

    /**
     * KEYPOINTS:
     * <p>
     * A good idea as early return as possible.
     * Handle from the last one, +1,to meet the one that is not 9.Then you can return the result.
     * otherwise.you need to create a new array with num.length +1 and copy it.
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
    public static int[] plusOneEarlyReturn(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) // early return
                return digits;
            digits[i] = 0;
        }
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        return ret;
    }
}

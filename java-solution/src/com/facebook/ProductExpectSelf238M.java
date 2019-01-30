package com.facebook;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/10/18
 * Talk is Cheap,Show me the Code.
 **/
public class ProductExpectSelf238M {
    //result[i]= {i前边的乘积}*{i后面的乘积}
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        //算前边的乘积
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        //算后面的乘积
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    public static void main(String[] rags)
    {
        int[] A = new int[]{2,3,4,5};
        ProductExpectSelf238M test  = new ProductExpectSelf238M();
        System.out.println(test.productExceptSelf(A));
    }
}

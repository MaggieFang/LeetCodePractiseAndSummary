package com.facebook;

import java.util.Arrays;
import java.util.Collections;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/6/18
 * Talk is Cheap,Show me the Code.
 **/
public class NextPermutation31M {
    /**
     * KEYPOINTS:
     * <p>
     *     e.g 给定325421，求其下一个比它大的数，怎么办呢？我们应该从最低位开始，1->2->4->5,这一段是升序的，
     *     也就是5421已经是最大数，不存在比它大的组合，我们继续找，1->2->4->5->2，出现降序这个位置就是我们要找的关键点，
     *     只需要将2与其后的数字中的（1,2,4,5）比它大的最小数，也就4替换，然后再将后面的数（1,2,2,5）升序排列
     *     便可得到下一个数，过程为：325421->345221->341225
     *    if we put importance on the digit. the 0th will be the most important and the (n-1)th
     *    will be the least important.so when to find the next number,
     *    we traverse from the least important digit to find the first descreasing order number,
     *    e.g. ith,  and then exchange it with the the number that are larger than it
     *    but smallest in latter items.
     *    e.g. 2 1 4 3, we will get 1, and exchange it with 3.to get 2 3 4 1
     *    ,but after we exchange it. we should reorder the latter one in sorted to get the smallest number
     *    of the least (i+1)th...(n-1)th(just reverse). so the result 2 3 1 4
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

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <=1){
            return;
        }

        int keyIdx = nums.length - 1;
        while(keyIdx > 0 && nums[keyIdx] <= nums[keyIdx-1]){
            keyIdx--; //寻找降序关键点
        }

        if(keyIdx == 0){////如果关键点下标为0，则原数据排列为全降序，不存在比它更大的数，将原排列升序重排
            Arrays.sort(nums);
            return;
        }

        int keyV = nums[keyIdx -1];//关键点下标对应的待替换数字
        for(int i = nums.length -1; i >= keyIdx; i--){ //寻找关键点后最小的且大于待替换数字的数据对应的下标
            if(nums[i] > keyV){//找到
                nums[keyIdx-1] = nums[i];
                nums[i] = keyV;
                break;
            }
        }
        Arrays.sort(nums,keyIdx,nums.length);//替换后，关键点后的数据进行升序重排
    }


    public void nextPermutation2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int p = nums.length - 2;
        while (p >= 0) {
//            if(nums[p] == nums[p+1]){
//                return;
//            }

            if (nums[p] >= nums[p + 1]) {
                p--;
            } else {
                break;
            }
        }

        if (p == -1) {
            reverse(nums, 0);
        } else {
            int target = nums[p];
            int minLargerIndex = p + 1;
            for (int i = p + 2; i < nums.length; i++) {
                if (nums[i] > target && nums[minLargerIndex] >= nums[i]) { // do not ignore the = condition.e.g.{2,3,1,3,3} if no ==, we will exchange 2th with 3th ,but we reverse it again.
                    minLargerIndex = i;
                }
            }
            int tmp = nums[minLargerIndex];
            nums[minLargerIndex] = nums[p];
            nums[p] = tmp;
            reverse(nums, p + 1);
        }
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            int tmp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = tmp;
        }

    }

    public static void main(String[] args) {

        int[] C = new int[]{3,2,5,4,2,1};
        new NextPermutation31M().nextPermutation(C);
        for(int i :C){
            System.out.print(i);
        }
    }
}

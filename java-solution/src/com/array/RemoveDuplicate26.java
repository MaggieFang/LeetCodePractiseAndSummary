package com.array;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class RemoveDuplicate26 {
    public static void main(String[] args) {

    }

    /**
     * KEYPOINTS:
     * <p>
     * 这是简单的只是算，但原题虽然只是让我们返回新的长度，但实际是要我们把数组也修改了.
     * 但其实只需要增加一行代码，有两个index，一个遍历使用，另一个标示没重复的位置，然后把每个的唯一放到没重复的位置上。
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
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int size = nums.length;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current == nums[i]) {
                --size;
            } else {
                current = nums[i];
            }

        }

        return size;
    }

    public int removeDuplicatedModifyArray(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int size = nums.length;
        int current = nums[0];
        int indexNoDuplicate = 0;
        for (int i = 1; i < nums.length; i++) {
            if (current == nums[i]) {
                --size;
            } else {
                current = nums[i];
                nums[++indexNoDuplicate] = nums[i];
            }
        }
        return size;

    }

    public int removeDuplicatedModifyArrayElegently(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int current = nums[0];
        int indexNoDuplicate = 0;
        for (int i = 1; i < nums.length; i++) {
            if (current != nums[i]) {
                current = nums[i];
                nums[++indexNoDuplicate] = nums[i];
            }
        }
        return indexNoDuplicate + 1;

    }

}

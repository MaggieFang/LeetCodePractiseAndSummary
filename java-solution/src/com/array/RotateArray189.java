package com.array;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/2/18
 * Talk is Cheap,Show me the Code.
 **/
public class RotateArray189 {
    public static void main(String[] args) {
        int[] t1 = new int[]{1,2,3,4,5,6,7};
        int[] t2 = new int[]{-1,-100,3,99};
        rotate(t1,3);
        rotate(t2,2);
    }

    /**
     * KEYPOINTS:
     * <p>
     *  （1）该问题可以当做把后面K个数倒着挪到最前边，那么可以先把后面K个数保存起来，
     *  然后数组整体往后挪，留出前边K个位给刚保存的K个数填充即可
     *  （2）注意！k不一定是比n小，如果k=n其实相当不用挪，k = k % nums.length;
     *  这个预处理可以简化掉k>=n的工作量，全部归为挪k`（k`<n）的情况，回到（1）
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *      temp[k]
     *      for i = 1 to k:
     *        temp[i] = A[n-i]
     *     move A index of  1 to n - k element forward k step;
     *     assign temp to A[1...k]
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY: O(k%num.length)
     * <p>
     **/
    public static void rotate(int[] nums, int k) {
        k = k % nums.length; //这步还是很关键的，例如n=3,k=4,实际的结果只需要挪一步
        int[] temp = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[i - nums.length + k] = nums[i];
        }
        int moveCount = nums.length - k;
        for (int i = 1; i <= moveCount; i++) {
            nums[nums.length - i] = nums[moveCount - i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}

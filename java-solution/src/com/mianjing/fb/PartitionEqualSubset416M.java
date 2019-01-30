package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class PartitionEqualSubset416M {
    /**
     * KEYPOINTS:
     * <p>
     * 这道题给了我们一个数组，问我们这个数组能不能分成两个非空子集合，使得两个子集合的元素之和相同。
     * 那么我们想，原数组所有数字和一定是偶数，不然根本无法拆成两个和相同的子集合，
     * 那么我们只需要算出原数组的数字之和，然后除以2，就是我们的target，
     * 那么问题就转换为能不能找到一个非空子集合，使得其数字之和为target。
     * 开始我想的是遍历所有子集合，算和，但是这种方法无法通过OJ的大数据集合。
     * 于是乎，动态规划 Dynamic Programming 就是我们的不二之选。我们定义一个一维的dp数组，
     * 其中dp[i]表示数字i是否是原数组的任意个子集合之和，那么我们我们最后只需要返回dp[target]就行了。
     * 我们初始化dp[0]为true，由于题目中限制了所有数字为正数，那么我们就不用担心会出现和为0或者负数的情况。
     * 那么关键问题就是要找出状态转移方程了，我们需要遍历原数组中的数字，对于遍历到的每个数字nums[i]，我们需要更新dp数组，
     * 要更新[nums[i], target]之间的值，那么对于这个区间中的任意一个数字j，如果dp[j - nums[i]]为true的话，
     * 那么dp[j]就一定为true，于是状态转移方程如下：
     * dp[j] = dp[j] || dp[j - nums[i]]      (nums[i] <= j <= target)
     * 有了状态转移方程，那么我们就可以写出代码了，这里需要特别注意的是，第二个for循环一定要从target遍历到nums[i]，
     * 而不能反过来，想想为什么呢？因为如果我们从nums[i]遍历到target的话，假如nums[i]=1的话，
     * 那么[1, target]中所有的dp值都是true，因为dp[0]是true，dp[1]会或上dp[0]，为true，dp[2]会或上dp[1]，为true，
     * 依此类推，完全使我们的dp数组失效了
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
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j]||dp[j - nums[i]];
            }
        }
        return dp[target];

    }

    public static void main(String[] a){
        int[] A = new int[]{1, 5, 11, 5};
        canPartition(A);
    }

}

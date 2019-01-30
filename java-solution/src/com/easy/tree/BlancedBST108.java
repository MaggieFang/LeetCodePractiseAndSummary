package com.easy.tree;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/28/18
 * Talk is Cheap,Show me the Code.
 **/
public class BlancedBST108 {
    public static void main(String[] args){
        BlancedBST108 tree = new BlancedBST108();
        int[] A = new int[]{-10,-3,0,5,9};
        tree.sortedArrayToBST(A);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructBST(nums, 0, nums.length - 1);

    }

    public TreeNode constructBST(int[] nums, int l, int r) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        if (l > r) {
            return null;
        }

        int mid = l + (r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, l, mid - 1);
        root.right = constructBST(nums, mid + 1, r);
        return root;
    }
}

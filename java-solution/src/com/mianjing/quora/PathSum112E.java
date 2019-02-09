package com.mianjing.quora;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-09
 * Talk is cheap,show me the Code.
 **/
public class PathSum112E {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

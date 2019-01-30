package com.facebook;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/10/18
 * Talk is Cheap,Show me the Code.
 **/
public class DiameterOfTree543 {
    public int diameterOfBinaryTree(TreeNode root) {
        // 1. lheight + rightHeight +1 ,经过root的情况
        // 2. 各自计算左右树的diameter  结果就是 Max(lHeight+rightHeigth+1, Max(ldiameter,rdiameter))
        if (root == null) {
            return 0;
        }
        int lHeight = getDepth(root.left);
        int rHeight = getDepth(root.right);
        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);
        return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));

    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);
        return Math.max(lDepth, rDepth) + 1;

    }

    //感觉一些递归，增加个member变得容易理解的多
    int ans;
    public int diameterOfBinaryTreeLC(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}

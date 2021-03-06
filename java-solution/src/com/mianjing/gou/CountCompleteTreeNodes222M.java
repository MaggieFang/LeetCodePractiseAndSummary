package com.mianjing.gou;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/30/18
 * Talk is Cheap,Show me the Code.
 **/
public class CountCompleteTreeNodes222M {
    /**
     * 这道题的变形可能是给你一个complete tree,编号 1,2,3....，给一个数n,求n是否是该树的一个节点。 求出count,if  n > count 不在
     **/
    /**
     * KEYPOINTS:
     * <p>
     * define heigh(level) fuction,0 when single node. we go left to get it. get h
     * and than check the heigh of right child hR, if hR +  1 == h, it means the root's left part is full
     * so  left nodes numbers is 2^(h) - 1, totoal =  2^(h) - 1 + 1(root) + count(rightchild)
     * if not. so the right child is full, 2^(h-1) -1 + 1 + count(left)
     *
     *  noticed that 2^n we can use 1 << n
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(log(n)^2) since I halve the tree in every recursive step, I have O(log(n)) steps
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        if (h == -1) return 0;
        int rightH = getHeight(root.right);
        if (rightH + 1 == h) {
            // left is full;
            return (1 << h) + countNodes(root.right);
        } else {
            return (1 << (h - 1)) + countNodes(root.left);
        }
    }

    private int getHeight(TreeNode root) {
        return root == null ? -1 : 1 + getHeight(root.left);
    }


    public int countNodesIterate(TreeNode root) {
        int h = getHeight(root);
        int ans = 0;
        while (root != null) {
            if (getHeight(root.right) == h - 1) {
                ans += (1 << h);
                root = root.right;
            } else {
                ans += (1 << h - 1);
                root = root.left;
            }
            h--;
        }
        return ans;
    }


    public int countNodesTimeLimit(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesTimeLimit(root.left) + countNodesTimeLimit(root.right);
    }
}

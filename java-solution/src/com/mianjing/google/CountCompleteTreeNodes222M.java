package com.mianjing.google;

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
     * and than check the heigh of right child, to see whether right sub height +  root equals to the whole height?
     * means if the right sub height == h -1
     * if yes,so the last node is in the right sub,so the left is full.
     * so  left nodes numbers is 2^(h) - 1, totoal =  2^(h) - 1 + 1(root) + count(rightchild)
     * if not. so the right child is full, 2^(h-1) -1 + 1 + count(left)
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
        return h == -1 ? 0 : getHeight(root.right) == h - 1 ?
                (1 << h) + countNodes(root.right) : (1 << (h - 1)) + countNodes(root.left);
    }

    public int getHeight(TreeNode root) {
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

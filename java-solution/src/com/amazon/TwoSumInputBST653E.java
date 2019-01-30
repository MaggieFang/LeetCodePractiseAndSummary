package com.amazon;

import com.easy.tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/5/18
 * Talk is Cheap,Show me the Code.
 **/
public class TwoSumInputBST653E {
    /**
     * KEYPOINTS:
     * <p>
     *    HashSet  to save the target values. and do layer travel.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n) We need to traverse over the whole tree once in the worst case.
     * <p>
     * SPACE COMPLEXITY: O(n)
     * <p>
    **/
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        HashSet<Integer> expect = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(expect.contains(node.val)){
                return true;
            }
            expect.add(k - node.val);
            if(node.left != null){
                q.add(node.left);
            }

            if(node.right != null){
                q.add(node.right);
            }

        }
        return false;
    }
}

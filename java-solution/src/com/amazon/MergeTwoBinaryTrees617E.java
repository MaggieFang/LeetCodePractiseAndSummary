package com.amazon;

import com.easy.tree.TreeNode;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class MergeTwoBinaryTrees617E {
    /**
     * KEYPOINTS:
     * <p>
     *
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(m). A total of m nodes need to be traversed.
     * Here, m represents the minimum number of nodes from the two given trees.
     * <p>
     * SPACE COMPLEXITY: O(m). The depth of the recursion tree can go upto m in the case of a skewed tree.
     * In average case, depth will be O(logm)
     * <p>
    **/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1,t2});
        while(!stack.isEmpty()){
            TreeNode[] ns = stack.pop();
            if(ns[0] == null || ns[1] == null){
                continue;
            }
            ns[0].val += ns[1].val;
            if(ns[0].left == null){
                ns[0].left = ns[1].left;
            }else{
                stack.push(new TreeNode[]{ns[0].left,ns[1].left});
            }

            if(ns[0].right == null){
                ns[0].right =ns[1].right;
            }else {
                stack.push(new TreeNode[]{ns[0].right,ns[1].right});
            }


        }
        return t1;
    }
}

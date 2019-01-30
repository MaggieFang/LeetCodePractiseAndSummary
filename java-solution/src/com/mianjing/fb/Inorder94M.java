package com.mianjing.fb;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class Inorder94M {
    /**
     * KEYPOINTS:
     * <p>
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(n). because the recursive function is T(n) = 2 *T(n/2)+1
     * <p>
     * <p>
     * SPACE COMPLEXITY:The worst case space required is O(n), and in the average case it's O(log(n))
     * <p>
     **/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        help(root, ans);
        return ans;


    }

    public void help(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        help(root.left, ans);
        ans.add(root.val);
        help(root.right, ans);
    }


    /**
     * KEYPOINTS:
     * <p>
     *
     *  keep pushing all left into stack.
     *  and pop it out, and to ans.
     *  cur = cur.right to do the right side.
     *  same with BSTIteractor173M
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
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();


        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;

    }


}



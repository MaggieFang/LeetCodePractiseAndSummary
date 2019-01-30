package com.Tree;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/15/19
 * Talk is Cheap,Show me the Code.
 **/
public class TreeMirror {
    //https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/  O(n)
    public boolean mirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
//        if(t1.val != t2.val) return false;
        return t1.val == t2.val && mirror(t1.left,t2.right) && mirror(t1.right, t2.left);
    }
}

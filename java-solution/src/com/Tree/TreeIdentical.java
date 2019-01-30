package com.Tree;

import com.easy.tree.TreeNode;

import java.util.Collections;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/15/19
 * Talk is Cheap,Show me the Code.
 **/
public class TreeIdentical {
    public boolean identical(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
//        if(t1.val != t2.val) return false;
        return t1.val == t2.val && identical(t1.left,t2.left) && identical(t1.right, t2.right);
    }

}

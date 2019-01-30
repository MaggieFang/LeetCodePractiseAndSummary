package com.mianjing.google;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/15/19
 * Talk is Cheap,Show me the Code.
 **/
public class TreeSimilar {
    //https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=470727&ctid=228656
    public boolean isSimilar(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSimilar(t1.left, t2.left) && isSimilar(t1.right, t2.right) ||
                (isSimilar(t1.left, t2.right) && isSimilar(t1.right, t2.left));
    }
}

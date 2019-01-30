package com.amazon;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class LowestCommonParentOfBST235E {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}

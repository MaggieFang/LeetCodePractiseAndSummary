package com.array;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-05
 * Talk is Cheap,Show me the Code.
 **/
public class LevelOrder107E {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        int height = findHeight(root);

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for(int i=0;i<height;i++){

            list.add(new ArrayList<Integer>());

        }

        bottomLevelTraversal(root,list,0);

        return list;
    }

    public int findHeight(TreeNode root){

        if (root == null)
            return 0;

        return 1+Math.max(findHeight(root.left),findHeight(root.right));

    }

    public void bottomLevelTraversal(TreeNode root, List<List<Integer>> list, int level){

        if(root == null)
            return;

        if(root.left != null)
            bottomLevelTraversal(root.left,list,level+1);

        list.get(list.size()-1 - level).add(root.val);

        if(root.right != null)
            bottomLevelTraversal(root.right,list,level+1);

    }
}

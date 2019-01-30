package com.amazon;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/5/18
 * Talk is Cheap,Show me the Code.
 **/
public class BinaryTreeLevelOrderTravel102M {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> i = new ArrayList<>();
        i.add(root);
        q.add(i);
        while(!q.isEmpty()){
            List<TreeNode> tmp = q.poll();
            if(tmp.size() == 0){
                break;
            }
            List<Integer> item = new ArrayList<>();
            List<TreeNode> toAdd = new ArrayList<>();
            for(TreeNode node : tmp){
                item.add(node.val);
                if(node.left != null){
                    toAdd.add(node.left);
                }

                if(node.right != null){
                    toAdd.add(node.right);
                }
            }
            q.add(toAdd);
            ans.add(item);
        }
        return ans;
    }
}

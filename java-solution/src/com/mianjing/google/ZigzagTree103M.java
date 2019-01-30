package com.mianjing.google;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/20/18
 * Talk is Cheap,Show me the Code.
 **/
public class ZigzagTree103M {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        //boolean odd = true;
        while(!q.isEmpty()){
            int size = q.size();
            int i = 0;
            List<Integer> item = new ArrayList<>();
            ans.add(item);

            while(i < size){
                TreeNode node = q.poll();
                item.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                i++;
            }
            if(ans.size() % 2 == 0){
                Collections.reverse(item);
            }

        }
        return ans;

    }
}

package com.facebook;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class BinaryTreeVerticalOrderTravel314M {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        HashMap<TreeNode,Integer> weight = new HashMap<>();
        queue.add(root);
        weight.put(root,0);
        int min = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int w  = weight.get(node);
            if(!map.containsKey(w)){
                map.put(w,new ArrayList<Integer>());
            }
            map.get(w).add(node.val);
            if(node.left != null){
                queue.add(node.left);
                weight.put(node.left, w-1);
            }
            if(node.right != null){
                queue.add(node.right);
                weight.put(node.right,w+1);
            }

            min = Math.min(min,w);// 保住最小，方便后面直接拿最小的开始输出
        }

        while(map.get(min) != null){
            result.add(map.get(min));
            min++;
        }
        return result;
    }
}

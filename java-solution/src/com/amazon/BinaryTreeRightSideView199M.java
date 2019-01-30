package com.amazon;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class BinaryTreeRightSideView199M {
    /**
     * KEYPOINTS:
     * <p>
     *    do layer travel. use a queue to put the current layers' nodes. so Queue<List<TreeNode>>
     *     when poll, the last element in the list is the righest in this layer. add to ans.
     *     then loop the list. to add the next lays' all nodes.
     *     when the list pollI() is null.we can end.
     *
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY: O(n)
     * <p>
    **/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        q.add(list);

        while(!q.isEmpty()){
            List<TreeNode> tmp = q.poll();
            if(tmp.size() == 0){
                break;
            }

            ans.add(tmp.get(tmp.size()-1).val);
            List<TreeNode> toAdd = new ArrayList<>();
            for(TreeNode node: tmp){
                if(node.left != null){
                    toAdd.add(node.left);
                }
                if(node.right != null){
                    toAdd.add(node.right);
                }
            }
            q.add(toAdd);
        }
        return ans;
    }
}

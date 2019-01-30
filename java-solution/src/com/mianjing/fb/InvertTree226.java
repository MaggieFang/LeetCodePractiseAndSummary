package com.mianjing.fb;

import com.easy.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class InvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;

        //same with the following
//        TreeNode  left = root.left;
//        root.left = root.right;
//        root.right = left;
//        invertTree(root.right);
//        invertTree(root.left);
//        return root;

    }

    public TreeNode inverTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}

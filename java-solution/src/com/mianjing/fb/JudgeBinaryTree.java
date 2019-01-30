package com.mianjing.fb;

import com.easy.tree.TreeNode;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class JudgeBinaryTree {
    /**
     * KEYPOINTS:
     * <p>
     * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=447855&extra=&page=1
     * 用一个Map<Node, Integer> 统计入度， 遇到任何一个Node入度 >1 return false, 统计完如果有多个点入度为0 return false.
     * otherwise return true
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public boolean isBinaryTree(TreeNode[] A) {
        if (A == null) {
            return true;
        }

        HashMap<TreeNode, Integer> map = new HashMap<>();
        for (TreeNode node : A) {
            if (node.left != null) {
                if (map.containsKey(node.left)) {
                    return false;
                }
                map.put(node.left, 1);
            }
            if (node.right != null) {
                if (map.containsKey(node.right)) {
                    return false;
                }
                map.put(node.right, 1);
            }
        }
        return map.size() == A.length - 1;

    }
}

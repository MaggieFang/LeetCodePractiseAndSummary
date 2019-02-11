package com.mianjing.kuola;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-09
 * Talk is cheap,show me the Code.
 **/
public class PathSumIII437E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  since it can start and end anywhere, so we can do dfs for each node. means the path begin that node.
     * </p>
     * TIME COMPLEXITY: O(n^2), dfs begin the first node n ,dfs begin the sec,worst is n-1 ..... begin the last node  1. so n+(n-1)+...1 =O(n^2).
     * if it is a balance tree it will be  O(nlogn)
     * SPACE COMPLEXITY: O(n)
     * </p>
     **/
    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> nodes = new ArrayList<>();
        preOrder(root, nodes);
        for (TreeNode node : nodes) {
            dfs(node, sum);
        }
        return ans;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            ans++;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    public void preOrder(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        preOrder(root.left, nodes);
        preOrder(root.right, nodes);
    }
}

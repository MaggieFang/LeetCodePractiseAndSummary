package com.amazon;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class AllNodesDistanceKInBinaryTree863M {
    /**
     * KEYPOINTS:
     * <p>
     *    dfs to build HashMap<Node,ParentNode> map;
     *    Queue to store FreqNode. A class node with distance from target.
     *    first put (target,0) in the queue
     *    poll  it, check left child,right child, parent. If not null. push (negborNode,dis+1) to queue.
     *    Do not forget Add Set<> visited.
     *
     * </p>
     * TIME COMPLEXITY:O(N)
     * <p>
     * SPACE COMPLEXITY:O(N)
     * <p>
    **/
    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        if (k == 0) {
            ans.add(target.val);
            return ans;
        }

        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, null, map); //build the (node:parent) relation.
        Queue<FreqNode> q = new LinkedList<>();  //bfs.
        HashSet<TreeNode> visited = new HashSet<>();

        FreqNode f = new FreqNode(target, 0); // (node,distance) from target. init one (target,0);
        q.add(f);
        visited.add(target);
        while (!q.isEmpty()) {
            f = q.poll();
            if (f.dis == k) {
                ans.add(f.node.val);
            } else {
                TreeNode left = f.node.left; //check left neighbor
                TreeNode r = f.node.right;  //right neighbor
                TreeNode p = map.get(f.node); // parent.

                if (left != null && !visited.contains(left)) {
                    q.add(new FreqNode(left, f.dis + 1));
                    visited.add(left);
                }
                if (r != null && !visited.contains(r)) {
                    q.add(new FreqNode(r, f.dis + 1));
                    visited.add(r);
                }
                if (p != null && !visited.contains(p)) {
                    q.add(new FreqNode(p, f.dis + 1));
                    visited.add(p);
                }
            }


        }

        return ans;
    }

    public static class FreqNode {
        int dis;
        TreeNode node;

        public FreqNode(TreeNode node, int dis) {
            this.dis = dis;
            this.node = node;
        }
    }

    public void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node != null) {
            map.put(node, parent);
            dfs(node.left, node, map);
            dfs(node.right, node, map);
        }

    }

    /**
     * knows how to find children with k distance.
     * @param node
     * @param k
     */
    public void findChild(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            ans.add(node.val);
        } else {
            findChild(node.left, k - 1);
            findChild(node.right, k - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.left = new TreeNode(6);
        TreeNode t = root.left.right = new TreeNode(2);
        t.left = new TreeNode(7);
        t.right = new TreeNode(4);
        AllNodesDistanceKInBinaryTree863M test = new AllNodesDistanceKInBinaryTree863M();
        System.out.println(test.distanceK(root, root.left, 2));
    }
}

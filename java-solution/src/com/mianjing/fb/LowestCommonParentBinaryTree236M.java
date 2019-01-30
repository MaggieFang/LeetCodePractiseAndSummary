package com.mianjing.fb;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class LowestCommonParentBinaryTree236M {

    /**
     * KEYPOINTS:
     * <p>
     *    find the path of the two nodes
     *
     * </p>https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return root;
        }
        if(root == p || root == q){
            return root;
        }
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        findPath(root,p,path1);
        findPath(root,q,path2);
        int i = 0;
        int len = Math.min(path1.size(),path2.size());
        while(i < len && path1.get(i) == path2.get(i)){
            i++;
        }
        return path1.get(i-1);

    }


    // Finds the path from root node to given root of the tree, Stores the
    // path in a vector path[], returns true if path exists otherwise false
    private boolean findPath(TreeNode root, TreeNode n, List<TreeNode> path)
    {
        // base case
        if (root == null) {
            return false;
        }
        // Store this node . The node will be removed if
        // not in path from root to n.
        path.add(root);

        if (root == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        // If not present in subtree rooted with root, remove root from
        // path[] and return false
        path.remove(path.size()-1);

        return false;
    }

    /**
     * KEYPOINTS:
     * <p>
     *
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

    // https://www.youtube.com/watch?v=13m9ZCB8gjw
    public TreeNode lowestCommonAncestorRecurrence(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestorRecurrence(root.left,p,q);
        TreeNode right = lowestCommonAncestorRecurrence(root.right,p,q);
        if(left == null && right == null){
            return null;
        }

        if(left != null && right != null){
            return root;
        }
        return left != null? left:right;

    }
//    /** This is my first Mind,change it root into array store. so there exist node i, its parent is (i-1)/2
//     * so I change it to store in array(with help of BSF).and then find the index of p,q and to find their parent.
//     * But memory Limit exceed.
//     * **/
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return null;
//        }
//
//        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        ArrayList<TreeNode> list = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            TreeNode n = queue.poll();
//            list.add(n);
//
//            if (n.left == null) {
//                queue.add(dummy);
//            } else {
//                queue.add(n.left);
//
//            }
//
//            if (n.right == null) {
//                queue.add(dummy);
//            } else {
//                queue.add(n.right);
//            }
//        }
//
//        int a = 0;
//        int b = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).val == p.val) {
//                a = i;
//            } else if (list.get(i).val == q.val) {
//                b = i;
//            }
//        }
//
//
//        while (true) {
//            if (a > b) {
//                a = (a - 1) / 2;
//            } else {
//                b = (b - 1) / 2;
//            }
//            if (a == b) {
//                break;
//            }
//        }
//
//        return list.get(a);
//
//    }
}

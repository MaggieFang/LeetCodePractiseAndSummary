package com.linkedin;

import com.easy.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-12
 **/
public class ClosestBinarySearchTreeValueII272H {
    /**
     * Clarification:
     * extension of ClosestBinarySearchTreeValue270E
     * </p>
     * Keypoints:
     * for ClosestBinarySearchTreeValue270E, we only need one, so we can keep the min and according to left < root < right to do
     * the binary seach to update possible more min element.
     * In this question, we need k elments. for BST: inOrder traversal will get an increasing order list. so one way we can do is do the
     * inOrder traversal and get a increasing list. and find K numbers closest to target in this list.
     * Actually, we can get the K elements during our traversal.if the result list size < k, add the element directly.
     * if the difference current element with target is less then the first element in result list, remove the first element from the result
     * and add this new element to the last.
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        inOrder(root, list, k, target);
        return list;
    }

    private void inOrder(TreeNode root, LinkedList<Integer> res, int k, double target) {
        if (root == null) return;
        inOrder(root.left, res, k, target);
        if (res.size() < k) {
            res.add(root.val);
        } else if (Math.abs(root.val - target) < Math.abs(res.getFirst() - target)) {
            res.removeFirst();
            res.addLast(root.val);
        }
        inOrder(root.right, res, k, target);
    }
}

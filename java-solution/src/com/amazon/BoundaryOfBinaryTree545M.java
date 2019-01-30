package com.amazon;

import com.easy.linkedlist.ListNode;
import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;


/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/7/18
 * Talk is Cheap,Show me the Code.
 **/
public class BoundaryOfBinaryTree545M {
    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(res, root.left);
            }
            if (root.right != null) {
                addLeaves(res, root.right);
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {//leaf只在leaf时候加，这样add到ans不用judge是否已经在,另外，不要试图用hashSet放结果再复制到List. 一个新元素加到Set,不能保证order的！
                res.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;//重要，左-右子-左子 情况
            }

        }
        addLeaves(res, root);
        Stack<Integer> s = new Stack<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }


    public static void main(String[] args){
        TreeNode h = new TreeNode(1,null,new TreeNode(2));
        TreeNode r = h.right;
        r.left = new TreeNode(3);
        r.right = new TreeNode(4);
        BoundaryOfBinaryTree545M t = new BoundaryOfBinaryTree545M();
        System.out.println(t.boundaryOfBinaryTree(h));
    }
}

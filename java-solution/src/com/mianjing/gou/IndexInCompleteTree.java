package com.mianjing.gou;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/12/19
 * Talk is Cheap,Show me the Code.
 **/
public class IndexInCompleteTree {

    public int getBitLen(int n) {
        if (n > 1) {
            return 1 + getBitLen(n / 2);
        }
        return 1;
    }


    public int getBitInIndex(int n, int i) {//get the bit on ith position
        return n & (1 << i); //== 0 说明这个位是0，!=0（不是1）说明这个位是1
    }

    public boolean indexInTree(TreeNode root, int index) {
        if (root == null) {
            return false;
        }

        if (index == 1) {
            return true;
        }

        int len = getBitLen(index);
        return indexInTree(root, index, len - 1);
    }

    public boolean indexInTree(TreeNode root, int n, int i) {
        if (root == null || i < 0) {
            return false;
        }

        if (root.val == n) {
            return true;
        }

        if (getBitInIndex(n, i - 1) != 0) {
            return indexInTree(root.right, n, i - 1);
        } else {
            return indexInTree(root.left, n, i - 1);
        }

    }

    public void printBit(int n) {
        if (n > 1) {
            printBit(n / 2);
        }
        System.out.print(n & 1);
    }

    public static void main(String[] args) {
        IndexInCompleteTree t = new IndexInCompleteTree();
        TreeNode root = new TreeNode(1);
        TreeNode l = root.left = new TreeNode(2);
        TreeNode r = root.right = new TreeNode(3);
        l.left = new TreeNode(4);
        l.right = new TreeNode(5);
        r.left = new TreeNode(6);
        r.right = new TreeNode(7);

        System.out.println(t.indexInTree(root, 2));
        System.out.println(t.indexInTree(root, 3));
        System.out.println(t.indexInTree(root, 4));
        System.out.println(t.indexInTree(root, 5));
        System.out.println(t.indexInTree(root, 6));
        System.out.println(t.indexInTree(root, 7));
        System.out.println(t.indexInTree(root, 8));
        System.out.println(t.indexInTree(root, 10));


    }
}

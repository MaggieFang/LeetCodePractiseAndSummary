package com.Tree;

import com.easy.tree.TreeNode;

import java.util.TreeMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/15/19
 * Talk is Cheap,Show me the Code.
 **/
class TreeSameStructure {
    //https://www.geeksforgeeks.org/check-if-two-trees-have-same-structure/

    public boolean same(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return same(t1.left, t2.left) && same(t1.right, t2.right);
    }


    public <T> boolean samee(TreeNodeGen<T> t1, TreeNodeGen<T> t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return samee(t1.left, t2.left) && samee(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNodeGen<Character> t1 = new TreeNodeGen<>('A');
        TreeNodeGen<Character> t2 = new TreeNodeGen<>('B');
        t1.left = new TreeNodeGen('A');
        t1.right = new TreeNodeGen('B');
        t2.left = new TreeNodeGen('C');
        System.out.println(new TreeSameStructure().samee(t1,t2));

    }

    static class TreeNodeGen<E> {
        E val;
        TreeNodeGen left;
        TreeNodeGen right;

        public TreeNodeGen(E val) {
            this.val = val;
        }
    }
}



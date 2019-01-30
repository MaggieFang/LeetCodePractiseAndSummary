package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/7/18
 * Talk is Cheap,Show me the Code.
 **/
public class BST {
    private BinaryNode root;
    List<BinaryNode> nodes = new ArrayList<>();

    public boolean insert(int data) {
        BinaryNode node = new BinaryNode(data);
        if (root == null) {
            root = null;
        } else {
            BinaryNode cur = root;
            BinaryNode parent = cur;
            while (cur != null) {
                parent = cur;
                if (data < root.data) {
                    cur = cur.left;
                } else if (data > root.data) {
                    cur = cur.right;
                } else {
                    return false;
                }

            }
            if (parent.data > data) {
                parent.left = node;
            } else if (parent.data < data) {
                parent.right = node;
            } else {
                return false;
            }
        }
        return true;
    }


    public void preorderTreeWalk(BinaryNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorderTreeWalk(root.left);
        preorderTreeWalk(root.right);
    }

    public void inorderTreeWalk(BinaryNode root) {
        if (root == null) {
            return;
        }
        inorderTreeWalk(root.left);
        System.out.println(root.data);
        inorderTreeWalk(root.right);
    }

    public void postorderTreeWalk(BinaryNode root) {
        if (root == null) {
            return;
        }
        postorderTreeWalk(root.left);
        postorderTreeWalk(root.right);
        System.out.println(root.data);

    }


    public BinaryNode findNodeInBST(BinaryNode root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            return root;
        }

        if (root.data > data) {
            return findNodeInBST(root.left, data);
        } else {
            return findNodeInBST(root.right, data);
        }
    }

    public BinaryNode findNodeInBSTIterator(BinaryNode root, int data) {

        while (root != null && root.data != data) {
            if (root.data > data) {
                root = root.left;
            } else {
                root = root.right;
            }

        }
        return root;
    }

    public BinaryNode minimum(BinaryNode root) {
        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public BinaryNode maximum(BinaryNode root) {
        if (root == null) {
            return null;
        }

        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public BinaryNode findParent(BinaryNode root, int data) {
        if (data == root.data) {
            return null;
        }

        BinaryNode cur = root;
        BinaryNode pre;
        while (true) {
            pre = cur;
            if (cur.data > data) {
                cur = cur.left;
            }else if(cur.data < data){
                cur = cur.right;
            }else {
                return pre;
            }
        }
    }


    public BinaryNode sucessor(BinaryNode root, int data) {
        //find the node
        BinaryNode cur = findNodeInBSTIterator(root, data);

        //have right child, return the min of right child tree;
        if (cur.right != null) {
            return minimum(cur.right);
        }

        // if the cur has no right child,we should move up till cur is in the left side of some specific node.
        BinaryNode parent = findParent(root,data);
        while (parent != null && parent.right == cur){
            cur = parent;
            parent = findParent(root,parent.data);
        }
        return parent;

    }

    public BinaryNode precessor(BinaryNode root, int data) {
        //find the node
        BinaryNode cur = findNodeInBSTIterator(root, data);

        //have left child, return the max of right child tree;
        if (cur.left != null) {
            return maximum(cur.left);
        }

        // if the cur has no left child,we should move up till cur is in the right side of some specific node.
        BinaryNode parent = findParent(root,data);
        while (parent != null && parent.left == cur){
            cur = parent;
            parent = findParent(root,parent.data);
        }
        return parent;

    }


}

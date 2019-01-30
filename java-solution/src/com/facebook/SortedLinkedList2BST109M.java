package com.facebook;

import com.easy.linkedlist.ListNode;
import com.easy.tree.TreeNode;


/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class SortedLinkedList2BST109M {
    /**
     * KEYPOINTS:
     * <p>
     *  1) Get the Middle of the linked list and make it root.
     * 2) Recursively do same for left half and right half.
     *   a) Get the middle of left half and make it left child of the root,created in step 1.
     *   b) Get the middle of right half and make it right child of the root created in step 1.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(nlogn)
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        int n = 0;
        while (node != null) {
            n++;
            node = node.next;
        }

        int s = 0;
        int e = n - 1;
        return getMiddle(head, s, e);

    }


    public TreeNode getMiddle(ListNode root, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        int count = 0;
        ListNode node = root;
        while (node != null && count < mid) {
            node = node.next;
            count++;
        }
        TreeNode treeRoot = new TreeNode(node.val);
        treeRoot.left = getMiddle(root, s, mid - 1);
        treeRoot.right = getMiddle(root, mid + 1, e);
        return treeRoot;

    }
}

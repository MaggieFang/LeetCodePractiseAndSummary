package com.mianjing.fb;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/14/18
 * Talk is Cheap,Show me the Code.
 **/
public class FindLeafPath257E {
    /**
     * KEYPOINTS:
     * <p>
     * 1
     * 2      3
     * 4    5        6
     * 7
     * the leafs on the left child will have some common nodes.  same with the right.
     * so we can search side by side.
     * <p>
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

    ArrayList<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return ans;
        }
        String path = "";
        findPath(root, path);
        return ans;

    }

    public void findPath(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            ans.add(path + root.val);
            return;
        }
        if (root.left != null) {
            findPath(root.left, path + root.val + "->");
        }

        if (root.right != null) {
            findPath(root.right, path + root.val + "->");
        }
    }
}

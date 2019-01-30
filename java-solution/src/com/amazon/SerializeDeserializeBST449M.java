package com.amazon;

import com.easy.tree.TreeNode;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/27/18
 * Talk is Cheap,Show me the Code.
 **/
public class SerializeDeserializeBST449M {
    private static final String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(SEP);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] sp = data.split(SEP);
        return build(sp, 0, sp.length - 1);

    }

    public TreeNode build(String[] sp, int idx, int right) {
        if (idx > right) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(sp[idx]));
        int rstart = rightIndex(sp, idx, right);
        root.left = build(sp, idx + 1, rstart - 1);
        root.right = build(sp, rstart, right);
        return root;
    }

    public int rightIndex(String[] sp, int cur, int right) {
        int ans = cur + 1;
        while (ans <= right && Integer.parseInt(sp[ans]) < Integer.parseInt(sp[cur])) {
            ans++;
        }
        return ans;
    }
}

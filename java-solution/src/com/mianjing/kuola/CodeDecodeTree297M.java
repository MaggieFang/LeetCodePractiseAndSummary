package com.mianjing.kuola;

import com.easy.tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class CodeDecodeTree297M {
    /**
     * KEYPOINTS:
     * <p>
     * 对于序列化，我们从根节点开始，如果节点存在，则将值存入输出字符串流，然后分别对其左右子节点递归调用序列化函数即可。
     * 对于去序列化，我们先读入第一个字符，以此生成一个根节点，然后再对根节点的左右子节点递归调用去序列化函数即可
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
    private static final String EMPTY = "#";
    private static final String SEP = ",";
    private int i = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();

    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(EMPTY).append(SEP);
        } else {
            sb.append(root.val).append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sp = data.split(SEP);
        return deserialize(sp);
    }

    public TreeNode deserialize(String[] sp) {
        if (i >= sp.length) {
            return null;
        }
        String s = sp[i++];
        if (EMPTY.equals(s)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserialize(sp);
        node.right = deserialize(sp);
        return node;


    }
}

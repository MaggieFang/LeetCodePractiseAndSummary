package com.mianjing.fb;

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
    private final static String EMPTY = "#";
    private final static String FILTER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();


    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(EMPTY).append(FILTER);
        } else {
            sb.append(root.val).append(FILTER);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] s = data.split(FILTER);
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, s);
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String s = queue.poll();
        if (EMPTY.equals(s)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}

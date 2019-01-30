package TreeAndGraph;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/20/18
 * Talk is Cheap,Show me the Code.
 **/
public class TreeTraversal {
    /**
     * To summarize, the algorithm prints the value of the current node, pushes the right child onto an
     * implicit stack, and moves to the left child. The algorithm pops the stack to obtain a new current
     * node when there are no more children (when it reaches a leaf). This continues until the entire tree
     * has been traversed and the stack is empty.
     */
    public static void preOder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.val);
        preOder(node.left);
        preOder(node.right);
    }

    public static void preOrderStack(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

    }
}

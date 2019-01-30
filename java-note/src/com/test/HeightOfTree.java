package com.test;

import java.util.Arrays;
import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/10/18
 * Talk is Cheap,Show me the Code.
 **/
public class HeightOfTree {
    public int maxDepth(BinaryNode node) {
        if (node == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            return Math.max(lDepth, rDepth) + 1;
        }
    }
}

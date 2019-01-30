package com.mianjing.google;


import com.easy.tree.TreeNode;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/9/19
 * Talk is Cheap,Show me the Code.
 **/
public class BuildTreeGivenChild {
    /**
     * KEYPOINTS:
     * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=467006&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3088%5D%5Bvalue%5D%3D1%26searchoption%5B3088%5D%5Btype%5D%3Dradio%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
     * <p>
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public TreeNode buildTree(char[][] pairs, char root) {
        HashMap<Character, TreeNode> map = new HashMap<>();
        for (char[] pair : pairs) {
            TreeNode p = map.getOrDefault(pair[1], new TreeNode(pair[1]));
            TreeNode c = map.getOrDefault(pair[0], new TreeNode(pair[0]));
            if (p.left == null) {
                p.left = c;
            } else {
                p.right = c;
            }
            map.put(pair[0], c);
            map.put(pair[1], p);
        }
        return map.get(root);
    }


}

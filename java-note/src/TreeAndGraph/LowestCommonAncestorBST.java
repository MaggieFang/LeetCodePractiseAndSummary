package TreeAndGraph;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/20/18
 * Talk is Cheap,Show me the Code.
 **/
public class LowestCommonAncestorBST {
    private TreeNode lcaBST(TreeNode node, TreeNode a, TreeNode b) {
        if (node == null) {
            return node;
        }
        if (node.val < a.val && node.val < b.val) {
           return lcaBST(node.right, a, b);
        } else if (node.val > a.val && node.val > b.val) {
           return lcaBST(node.left, a, b);
        } else {
            return node;
        }
    }
    private TreeNode lcaBSTNORecur(TreeNode node, TreeNode a, TreeNode b){
        while (node != null){
            if(node.val < a.val && node.val < b.val){
                node = node.right;
            }else if(node.val > a.val && node.val > b.val){
                node = node.left;
            }else {
                return  node;
            }
        }
        return null;
    }


}

package TreeAndGraph;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/20/18
 * Talk is Cheap,Show me the Code.
 **/
public class UnbalancedBST {
    public void rotateRight(TreeNode oldRoot){
        TreeNode newRoot = oldRoot.left;
        oldRoot.left = newRoot.right;
        newRoot.right = oldRoot;
    }
}

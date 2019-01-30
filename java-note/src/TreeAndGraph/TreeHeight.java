package TreeAndGraph;


/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/20/18
 * Talk is Cheap,Show me the Code.
 **/
public class TreeHeight {
    public static int treeHeight(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        return 1+Math.max(treeHeight(treeNode.left),treeHeight(treeNode.right));

    }
}

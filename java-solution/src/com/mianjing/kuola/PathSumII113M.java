package com.mianjing.kuola;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-09
 * Talk is cheap,show me the Code.
 **/
public class PathSumII113M {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, sum, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs(TreeNode root, int sum, List<Integer> pre, List<List<Integer>> ans) {
        sum -= root.val;
        pre.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(pre));
            pre.remove(pre.size() - 1);
            return;
        }
//        if(sum != 0){ // 到中间节点可能出现sum==0情况，但不代表这个路不能走。e.g 1,-2,-3,1,3,-2,null,-1。 sum = -1 到-2节点sum = 0,但往下还有-1,1到leaf sum可以又0了
        if (root.left != null) {
            dfs(root.left, sum, pre, ans);
        }
        if (root.right != null) {
            dfs(root.right, sum, pre, ans);
        }
//        }
        pre.remove(pre.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = root.left = new TreeNode(4);
        TreeNode right = root.right = new TreeNode(8);
        left.left = new TreeNode(7);
        left.right = new TreeNode(2);
        right.right = new TreeNode(2);
        PathSumII113M t = new PathSumII113M();
        System.out.println(t.pathSum(root, 11));
    }
}

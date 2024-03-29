package hellozepp.tree;

import hellozepp.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 难度2星
 */
public class Solution113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> list = new ArrayList<>();

        dfs(list, new ArrayList<>(), root, targetSum);

        return list;
    }


    private void dfs(List<List<Integer>> list, List<Integer> subList, TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        subList.add(root.val);
        sum -= root.val;

        if (root.right == null && root.left == null) {
            if (sum == 0) {
                list.add(new ArrayList<>(subList));
            }
            return;
        }

        dfs(list, new ArrayList<>(subList), root.left, sum);
        dfs(list, new ArrayList<>(subList), root.right, sum);


    }
}
package hellozepp.tree;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

import java.util.*;


/**
 * 二叉树的层次遍历
 * <p>
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 难度1星
 */
public class Solution102 {

    public class LevelTreeNode {
        int level;
        TreeNode node;

        LevelTreeNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<LevelTreeNode> que = new LinkedList<>();
        que.offer(new LevelTreeNode(root, 0));
        while (!que.isEmpty()) {
            LevelTreeNode cur = que.poll();
            if (cur.level == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(cur.level).add(cur.node.val);
            if (cur.node.left != null) {
                que.offer(new LevelTreeNode(cur.node.left, cur.level + 1));
            }
            if (cur.node.right != null) {
                que.offer(new LevelTreeNode(cur.node.right, cur.level + 1));
            }
        }
        return res;
    }

    /**
     *  非递归版本层序遍历，即 bfs
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int h = 0;
        int c = 1;
        int next = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (h == result.size()) {
                result.add(h, new ArrayList<>());
            }
            result.get(h).add(node.val);
            c--;
            if (node.left != null) {
                q.add(node.left);
                next++;
            }
            if (node.right != null) {
                q.add(node.right);
                next++;
            }

            if (c == 0) {
                c = next;
                next = 0;
                h++;
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> rowResult = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        int num = 1;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            rowResult.add(now.val);
            num--;
            if (now.left != null) {
                queue.add(now.left);
                next++;
            }
            if (now.right != null) {
                queue.add(now.right);
                next++;
            }

            if (num == 0) {
                num = next;
                next = 0;
                result.add(rowResult);
                rowResult = new ArrayList<Integer>();
            }

        }

        return result;
    }

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        track(root, list, 0);
        return list;
    }

    private void track(TreeNode root, List<List<Integer>> list, int h) {

        if (root == null) {
            return;
        }

        // size等于层高表示未创建
        if (h == list.size()) {
            list.add(h, new ArrayList<>());
        }
        list.get(h).add(root.val);
        track(root.left, list, h + 1);
        track(root.right, list, h + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.left.left = new TreeNode(15);
        treeNode.left.right = new TreeNode(16);
        treeNode.right.right = new TreeNode(7);
        System.out.println(new Solution102().levelOrder1(treeNode));
        System.out.println(new Solution102().levelOrder1(null));
        System.out.println(new Solution102().levelOrder1(treeNode.right.right));
    }
}
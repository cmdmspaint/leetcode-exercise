package hellozepp.tree;

import hellozepp.TreeNode;

/**
 *
 *
 * 将二叉树转化为 链表形势 （下一个节点放在 right子树）
 * 题目给的顺序是前序遍历，但是这样做出来都是左子树方向的链表，正好反过来。
 * 这种递归先向右的乍一看还得懵好久，感觉自己思维定式好严重啊。膜拜一下神仙思路，这等于是右向的后序遍历了吧
 * （先序遍历形式）
 *
 */
public class Solution114 {

    private TreeNode prv;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = prv;
        root.left = null;
        prv = root;

    }
}
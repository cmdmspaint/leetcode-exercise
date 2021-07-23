package hellozepp.tree;

import hellozepp.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 求二叉树的 LCA
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q
 * 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 分析：
 *
 * 两个节点的公共父节点要么在左子树有么在右子树,否则在跟上。所以采用递归的方式来遍历左子树和右子树。直到当前节点为空或者当前节点的为p或者q节点。
 *
 * 解法：
 * 使用二叉树先序遍历:
 * ● 如果当前节点等于a或者b，则返回当前节点;
 * ● 如果左孩子和右孩子都返回非空，则返回当前节点;
 * ● 如果其中一个孩子非空，则返回对应孩子返回的值;
 * ● 孩子都为空，返回空。
 *
 * 解法：
 * 这个basecase问题是，递归到最后root==null或者rooot==p/q，返回root（此时的root不一定是根结点啦，因为后面递归的是root.left还有root.right）
 * ，要么是空，要么是p要么是q（因为p q也可以作为自身的父结点）
 *
 * 然后下面是两个递归，一个是左孩子和p q的递归，一个是右孩子和p q的递归，总能找到最后要么root==null/p/q的情况
 *
 * 然后最后的返回值是  return l != null && r != null ? root : l == null ? r : l;
 *
 * （1）左子树和右子树都为不为空（公共节点不在左右子树上），那么root就是p q的公共父结点
 *
 * （2）左子树为空，那么在右子树上，否则在左子树上
 * 【难度：Easy】
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * 难度2星
 */
public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    //————————————————
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        List<TreeNode> pathp = new ArrayList<>();
        List<TreeNode> pathq = new ArrayList<>();
        pathp.add(root);
        pathq.add(root);

        getPath(root, p, pathp);
        getPath(root, q, pathq);

        TreeNode lca = null;
        for (int i = 0; i < pathp.size() && i < pathq.size(); i++) {
            if (pathp.get(i) == pathq.get(i)) {
                lca = pathp.get(i);
            } else {
                break;
            }
        }
        return lca;
    }

    private boolean getPath(TreeNode root, TreeNode n, List<TreeNode> path) {
        if (root == n) {
            return true;
        }

        if (root.left != null) {
            path.add(root.left);
            if (getPath(root.left, n, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right);
            if (getPath(root.right, n, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }

        return false;
    }

    /**
     * 二叉树节点定义:
     * struct Node {
     * Node * left;
     * Node * right;
     * int x;
     * };
     * 假设二叉树中不同节点的 x 互不相同，且给定一个根节点 root，一个节点对应的 x 列 表 node_list，
     * node_list 中元素互不重复，问 node_list 中对应节点的最低公共祖先对 应的 x 是多少?
     *
     * 假设 2 <= node_list.size() <= 2000
     * 请实现函数:int FindLowestCommonAncestor(Node * root, std::vector<int> & node_list);
     * - 例子:
     * [20, 4] => 20
     * [20, 4, 60] => 100 [4, 60, 7] => 100
     *    100
     *  20      3
     * 4 null 60 7
     *
     * 时间复杂度最坏情况为 O(k) + O(n) 额外空间复杂度为 O(k) + 树高导致的复杂度
     * */
    public Integer lowestCommonAncestor2(TreeNode root, List<Integer> nodeList) {
        int hasVal = 0;
        if (root == null || nodeList.isEmpty()) {
            return hasVal;
        }
        if (nodeList.contains(root.val)) {
            hasVal = 1;
        }
        Integer left = lowestCommonAncestor2(root.left, nodeList);
        Integer right = lowestCommonAncestor2(root.right, nodeList);
        hasVal = left + right + hasVal;
        return hasVal == nodeList.size() ? root.val : hasVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(20);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution236().lowestCommonAncestor(root, root.left, root.left.left).val); // 20
        System.out.println(new Solution236().lowestCommonAncestor2(root, Arrays.asList(20, 4, 60))); // 100
        System.out.println(new Solution236().lowestCommonAncestor2(root, Arrays.asList(20, 4))); // 20
        System.out.println(new Solution236().lowestCommonAncestor2(root, Arrays.asList(20, 100))); // 100
        root = new TreeNode(100);
        System.out.println(new Solution236().lowestCommonAncestor2(root, Arrays.asList(100))); // 100
        root = new TreeNode(100);
        root.left = new TreeNode(20);
        System.out.println(new Solution236().lowestCommonAncestor2(root, Arrays.asList(20))); // 20
    }
}
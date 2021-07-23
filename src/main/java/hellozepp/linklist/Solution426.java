package hellozepp.linklist;

import java.util.Stack;

/**
 * @Author: zhanglin
 * @Date: 2021/5/20
 * @Time: 10:41 AM
 * https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * 将一个二叉搜索树BST就地转化为一个已排序的双向循环链表。可以将左右孩子指针作为双向循环链表的前驱和后继指针。
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，
 * 第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 转换结果满足下面条件:
 * 1. 不要新建一个链表空间，要原地做;直接使用 left 和 right 指针
 * 2. 转换后的双向链表节点顺序要与中序遍历的结果一致
 * 3. 二叉树最左边 的节点作为双向链表的头节点
 */
public class Solution426 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // 重写递归
    Node pre = null, first = null;

    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return root;
        }

        inorder1(root);
        first.right = pre;
        pre.left = first;
        return first;
    }

    private void inorder1(Node cur) {
        if (cur == null) {
            return;
        }
        inorder1(cur.left);
        if (first == null) {
            first = cur;
        }
        if (pre == null) {
            pre = first;
        } else {
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        inorder1(cur.right);
    }

    // ------------------递归----------------
//    private Node first;
//    private Node pre;

    /**
     * 递归，最后出递归时的pre即为最后一个结点
     * first为最左边只赋值一次，等递归结束后跟最后一个节点pre互指前驱后继即可
     * @param root
     * @return
     */
    public Node treeToDoublyList1(Node root) {
        if (root == null) {
            return root;
        }
        first = pre = null;
        inorder(root);
        first.left = pre;
        pre.right = first;
        return first;
    }

    /**
     * 中序遍历inorder 左 中 右，访问bst可以保证结果是有序的
     *    4
     *  2    5
     *1   3
     * @param cur
     */
    public void inorder(Node cur) {
        if (cur == null) {
            return;
        }
        inorder(cur.left);

        if (first == null) {
            first = cur;
        }
        if (pre == null) {
            pre = first;
        } else {
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        inorder(cur.right);
    }

    // ------------------非递归----------------
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Stack<Node> s = new Stack<>();
        Node first = null, pre = null;
        Node cur = root;
        Node tmp = null;
        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            tmp = s.pop();
            if (first == null) first = tmp;
            if (pre == null) pre = first;
            else {
                tmp.left = pre;
                pre.right = tmp;
                pre = tmp;
            }
            cur = tmp.right;
        }
        first.left = tmp;
        tmp.right = first;
        return first;
    }

    public static void main(String[] args) {
        // 4 2 5 1 3 转为 12345
        Node a = new Node(4,
                new Node(2, new Node(1), new Node(3)),
                new Node(5));
        Node node = new Solution426().treeToDoublyList1(a);
        System.out.println(node.val + "," + node.left.val + "," + node.left.left.val + "," + node.left.left.left.val + "," + node.left.left.left.left.val + "," + node.left.left.left.left.left.val);
        System.out.println(node.val + "," + node.right.val + "," + node.right.right.val + "," + node.right.right.right.val + "," + node.right.right.right.right.val + "," + node.right.right.right.right.right.val);

    }
}

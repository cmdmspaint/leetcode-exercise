package hellozepp.tree;

import hellozepp.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给定中序遍历和 后序遍历 构建二叉树
 * <p>
 * 难度2星
 */
public class Solution106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(" ");
            Node node = createTree(str[0], str[1]);
            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                Node head = queue.poll();
                sb.append(head.ch);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            System.out.println(sb);
        }
    }

    private static Node createTree(String inOrder, String postOrder) {
        if (inOrder.isEmpty() || postOrder.isEmpty()) {
            return null;
        }
        char ch = postOrder.charAt(postOrder.length() - 1);
        Node root = new Node(ch);
        int i = inOrder.indexOf(ch);
        root.left = createTree(inOrder.substring(0, i), postOrder.substring(0, i));
        root.right = createTree(inOrder.substring(i + 1), postOrder.substring(i, inOrder.length() - 1));
        return root;
    }

    static class Node {
        char ch;
        Node left;
        Node right;

        Node(char ch) {
            this.ch = ch;
        }
    }

    // ------------------------------------------------
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder.length - 1, inorder.length - 1, 0, postorder, inorder);
    }

    public TreeNode build(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (inEnd > inStart) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);

        int index = 0;
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        root.left = build(postStart - (inStart - index) - 1, index - 1, inEnd, postorder, inorder);
        root.right = build(postStart - 1, inStart, index + 1, postorder, inorder);

        return root;
    }
}

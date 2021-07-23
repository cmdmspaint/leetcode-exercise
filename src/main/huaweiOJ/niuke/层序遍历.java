import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给了二叉树的中序和后序遍历，求层序遍历。输入 CBAEDF CBEFDA ，输出应该是ABDCEF
 * DCBGEAHFIJK DCEGBFHKJIA = ABICGHJDEFK
 */
public class 层序遍历 {
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
}
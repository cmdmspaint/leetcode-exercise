import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/25
 * @Time: 9:25 PM
 * 从单向链表中删除指定值的节点
 * 题目描述
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 *
 * 链表的值不能重复。
 *
 * 构造过程，例如输入一行数据为:
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 * 则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
 * 1 2 表示为
 * 2->1
 * 链表为2->1
 *
 * 3 2表示为
 * 2->3
 * 链表为2->3->1
 *
 * 5 1表示为
 * 1->5
 * 链表为2->3->1->5
 *
 * 4 5表示为
 * 5->4
 * 链表为2->3->1->5->4
 *
 * 7 2表示为
 * 2->7
 * 链表为2->7->3->1->5->4
 *
 * 最后的链表的顺序为 2 7 3 1 5 4
 *
 * 最后一个参数为2，表示要删掉节点为2的值
 * 删除 结点 2
 *
 * 则结果为 7 3 1 5 4
 *
 * 链表长度不大于1000，每个节点的值不大于10000。
 * 测试用例保证输入合法
 *
 *
 * 输入描述:
 * 输入一行，有以下4个部分：
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 *
 * 输出描述:
 * 输出一行
 * 输出删除结点后的序列，每个数后都要加空格
 *
 * 示例1
 * 输入
 * 复制
 * 5 2 3 2 4 3 5 2 1 4 3
 * 输出
 * 复制
 * 2 5 4 1
 * 说明
 * 形成的链表为2->5->3->4->1
 * 删掉节点3，返回的就是2->5->4->1
 * 示例2
 * 输入
 * 复制
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 * 输出
 * 复制
 * 7 3 1 5 4
 */
public class Main48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Node head = new Node(sc.nextInt());
        for (int i = 0; i < len - 1; i++) {
            insert(head, new Node(sc.nextInt()), new Node(sc.nextInt()));
        }
        head = deleteNode(head, new Node(sc.nextInt()));
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static void insert(Node head, Node node, Node p) {
        Node cur = head;
        while (cur != null) {
            if (cur.val == p.val) {
                Node next = cur.next;
                cur.next = node;
                node.next = next;
                break;
            }
            cur = cur.next;
        }
    }

    private static Node deleteNode(Node head, Node del) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == del.val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
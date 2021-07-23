package hellozepp.linklist;

import hellozepp.ListNode;


/**
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * 解法：三个指针pre,cur,next,pre用于遍历dummy，cur代表当前要插入的数，next临时存储下一个，
 * 维护dummy保存插入进来的值，内循环每次从dummy链表选一个不大于cur的位置来插入cur的值
 * 找到后的插入过程：先cur.next->pre.next指向找到的比他大的数（都小指向空），再讲pre.next指向cur，然后pre回到dummy，cur下移next
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 难度2星
 *
 * FIXME
 *
 */
public class Solution147 {


    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode curr = head;

        ListNode next = null;
        while (curr != null) {

            next = curr.next;
            while (pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }

            curr.next = pre.next;
            pre.next = curr;
            pre = dummy;
            curr = next;
        }
        return dummy.next;
    }

    // 重写一遍
    public ListNode insertionSortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode next = null;
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null) {
            next = cur.next;
            while (pre.next != null && cur.val > pre.next.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }
}
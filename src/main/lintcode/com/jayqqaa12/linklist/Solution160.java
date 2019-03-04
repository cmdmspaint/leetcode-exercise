package com.jayqqaa12.linklist;

import com.jayqqaa12.ListNode;


/**
 * 找到2个链表的交集
 * <p>
 * 难度2星
 */
public class Solution160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;


        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
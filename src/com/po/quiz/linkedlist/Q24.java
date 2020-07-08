package com.po.quiz.linkedlist;

import com.po.leetcode.ListNode;

public class Q24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode connectTo = dummy;

        //(previous toC)cT -> n1 -> n2 -> toC => cT -> n2 -> n1 -> toC
        while (connectTo.next != null && connectTo.next.next != null){
            ListNode first = connectTo.next;
            ListNode second = first.next;
            ListNode toConnected = second.next;
            connectTo.next = second;
            second.next = first;
            first.next = toConnected;
            connectTo = first;
        }

        return dummy.next;
    }
}

package com.po.quiz.linkedlist;

import com.po.leetcode.ListNode;

public class Q876 {
    public ListNode middleNode(ListNode head) {
        int num = 0;
        ListNode tmp = head;
        while (tmp != null){
            num++;
            tmp = tmp.next;
        }
        for(int i = 0; i < (num / 2); i++){
            head = head.next;
        }
        return head;
    }
}

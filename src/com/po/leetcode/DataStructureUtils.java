package com.po.leetcode;

public class DataStructureUtils {
    public static ListNode getListNode(Integer... ints){
        ListNode head = null;
        ListNode cur = null;
        for(Integer i : ints){
            ListNode node = new ListNode(i);
            if(cur == null){
                head = node;
                cur = node;
            } else {
                cur.next = node;
                cur = node;
            }
        }
        return head;
    }

    public static void printlist(ListNode node){
        while (node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }
}

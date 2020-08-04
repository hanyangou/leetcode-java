package com.po.quiz.linkedlist;

import com.po.leetcode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * adding num from the tail
 * challenge comes from how to travel back from the tail, since it is linked list
 *
 */
public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        //how to track the header?
        ListNode dummy = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int f = stack1.isEmpty() ? 0 : stack1.pop();
            int s = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = f + s + carry;
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            cur.next = dummy;
            dummy = cur;
        }
        return dummy;
    }

    public ListNode reverseway(ListNode l1, ListNode l2){
        //including 0
        //adding the num from the tail. since it is single linked list
        //swap if l2.size() > l1.size()
        if(len(l1) < len(l2)){
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = l1;
        int carry = 0;
        while (l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            l1.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode prev = l1;
        while (carry != 0){
            if(l1 != null){
                int sum = l1.val + carry;
                l1.val = sum % 10;
                carry = sum / 10;
                prev = l1;
                l1 = l1.next;
            } else {
                ListNode newnode = new ListNode(carry);
                prev.next = newnode;
                carry = 0;
            }
        }

        return reverse(dummy);
    }
    public int len(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }

    public ListNode reverse(ListNode node){
        ListNode dummy = node;
        ListNode next = node.next;
        ListNode cur = node;
        while (next != null){
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        dummy.next = null; //original first node pointing to null;
        return cur;
    }
}
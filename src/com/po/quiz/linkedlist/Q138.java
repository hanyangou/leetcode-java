package com.po.quiz.linkedlist;

import java.util.HashMap;

public class Q138 {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node cur = head;
        Node prev = dummy;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null){
            Node n = new Node(cur.val);
            map.put(cur, n);
            prev.next = n;
            prev = n;
            cur = cur.next;
        }
        Node c = dummy.next;
        while (head != null){
            c.random = map.get(head.random);
            head = head.next;
            c = c.next;
        }
        return dummy.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}



package com.po.quiz.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * double linked list
 * hashtable
 */
public class AllOne {
    class Node {
        Integer seq;
        Set<String> keys;

        public Node(int seq) {
            this.seq = seq;
            keys = new HashSet<>();
        }

        public Node(int seq, String key) {
            this.seq = seq;
            keys = new HashSet<>();
            keys.add(key);
        }
    }

    class DoubleLinkedList {
        Node node;
        DoubleLinkedList prev;
        DoubleLinkedList next;

        public DoubleLinkedList(Node node) {
            this.node = node;
        }
    }

    Map<String, DoubleLinkedList> map;
    DoubleLinkedList head;
    DoubleLinkedList tail;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        map = new HashMap<>();
        head = new DoubleLinkedList(new Node(0));
        tail = new DoubleLinkedList(new Node(0));
        head.next = tail;
        tail.prev = head;
    }

    private void addAfter(DoubleLinkedList before, DoubleLinkedList after) {
        before.next.prev = after;
        after.prev = before;
        after.next = before.next;
        before.next = after;
    }

    private void addBefore(DoubleLinkedList anchor, DoubleLinkedList add) {
        anchor.prev.next = add;
        add.prev = anchor.prev;
        add.next = anchor;
        anchor.prev = add;
    }

    private void remove(DoubleLinkedList node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private boolean isListEmpty() {
        return isTail(head.next);
    }

    private boolean isTail(DoubleLinkedList node) {
        return node.node.seq == 0;
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        DoubleLinkedList node = map.get(key);
        if (node == null) { //this key does not exist yet, insert it into seq:1
            DoubleLinkedList one = head.next;
            if (one.node.seq != 1) {
                one = new DoubleLinkedList(new Node(1, key));
                addAfter(head, one);
            } else {
                one.node.keys.add(key);
            }
            map.put(key, one);
        } else { //exists. get related node and inc the key
            DoubleLinkedList increase = node.next;
            if (increase.node.seq != node.node.seq + 1) { //next node is not neighbor, create one.
                DoubleLinkedList toInsert = new DoubleLinkedList(new Node(node.node.seq + 1));
                toInsert.node.keys.add(key);
                addAfter(node, toInsert);
                map.put(key, toInsert);
            } else { //neighbor is there, add keoy to it and update map
                increase.node.keys.add(key);
                map.put(key, increase);
            }
            node.node.keys.remove(key);
            if (node.node.keys.size() == 0) remove(node);
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        DoubleLinkedList node = map.get(key);
        if (node == null) return;
        int seq = node.node.seq;
        DoubleLinkedList prev = node.prev;
        node.node.keys.remove(key);
        if (node.node.keys.size() == 0) {
            remove(node);
        }
        if (seq == 1) {
            map.remove(key);
        } else {
            if (prev.node.seq == seq - 1) { //neighbor already exists
                prev.node.keys.add(key);
                map.put(key, prev);
            } else {
                DoubleLinkedList decrease = new DoubleLinkedList(new Node(seq - 1, key));
                addAfter(prev, decrease);
                map.put(key, decrease);
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        Node node = tail.prev.node;
        if (node.seq == 0) return "";
        return node.keys.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        Node node = head.next.node;
        if (node.seq == 0) return "";
        return node.keys.iterator().next();
    }
}

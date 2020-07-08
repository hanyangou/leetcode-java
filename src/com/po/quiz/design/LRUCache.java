package com.po.quiz.design;

import java.util.HashMap;
import java.util.Map;

/***
 * how to track the least used obj?
 *  - how to move the obj that is already in cache to top pos?? delete it and add it again
 *  queue seems to be a good DS since its FIFO - yes, with doubled linked list to speed up the ops
 *
 *  - queue to track the sequence
 *  - map to track key / DoubleLinkedListNode
 *
 *  some pitfalls:
 *  1. exceeding capacity
 *  2. the key is in cache already but put different val
 *  3. get -- should update Last Recent queue
 */
public class LRUCache {

    class DLinkedList{
        int key;
        int val;
        DLinkedList prev;
        DLinkedList next;

        public DLinkedList(){};
        public DLinkedList(int key, int val){
            this.key = key;
            this.val = val;
        };

    }

    int capacity;
    int size;
    DLinkedList head;
    DLinkedList tail;
    Map<Integer, DLinkedList> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        DLinkedList cached = cache.get(key);
        removeNode(cached);
        addNode(cached);
        return cached.val;
    }

    public void put(int key, int value) {
        //two scenarios: new obj or obj in cache already
        //new obj: simply put into cache and remove the eldest one if exceeding capacity
        //obj in cache: move obj to head by removing it and re-insert it
        if(cache.containsKey(key)){
            DLinkedList cached = cache.get(key);
            cached.val = value;
            removeNode(cached);
            addNode(cached);
        } else {
            DLinkedList dLinkedList = new DLinkedList(key, value);
            //adding to queue and cache
            cache.put(key, dLinkedList);
            addNode(dLinkedList);
            if(size == capacity){ //if exceeding capacity
                DLinkedList last = tail.prev;
                removeNode(last);
                cache.remove(last.key);
            } else {
                size++;
            }
        }
    }

    private void addNode(DLinkedList dLinkedList){
        //mention omit not null check for now
        //check size and capacity
        dLinkedList.next = head.next;
        dLinkedList.prev = head;
        head.next.prev = dLinkedList;
        head.next = dLinkedList;
        return;
    }

    private void removeNode(DLinkedList dLinkedList){
        //mention omit not null check for now
        dLinkedList.prev.next = dLinkedList.next;
        dLinkedList.next.prev = dLinkedList.prev;
        return;
    }
}

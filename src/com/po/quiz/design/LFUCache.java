package com.po.quiz.design;

import java.util.HashMap;
import java.util.Map;

/***
 * DoubleLinkedList queue
 * Map caches : [key, DLinkedList]
 * Map freqs : [freq, List[DLinkedList]]
 *
 * How to maintain the order of nodes in queue by frequency
 * OR
 * You dont, just tracking min freq and use freqs map to get the node and remove the node in queue and caches
 * queue only maintain the LRU
 *
 * We also need to maintain the feq in the cached obj, since we need to to retrieve the list of objs with same freqs in O(1)
 *
 * When popping the least frequent used obj, how to obtain the next LFU obj in O(1) ?? maintain min_freq during get and put operations
 * iterate through the map is not the option since it takes O(n) where n is the size of map
 */
class LFUCache {

    class DLinkedList{
        int key;
        int val;
        int freq;
        DLinkedList prev;
        DLinkedList next;
        public DLinkedList(){
        };
        public DLinkedList(int key, int val){
            this.key = key;
            this.val = val;
            freq = 1;
            prev = new DLinkedList();
            next = new DLinkedList();
        };
    }

    class LRUQueue{
        DLinkedList head;
        DLinkedList tail;
        public LRUQueue(){
            head = new DLinkedList();
            tail = new DLinkedList();
            head.next = tail;
            tail.prev = head;
        }

        public boolean isEmpty(){
            return head.next == tail;
        }
        //add node to head
        public void addNode(DLinkedList node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        //remove node from random position
        public void removeNode(DLinkedList node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        public DLinkedList popTail(){
            DLinkedList last = tail.prev;
            removeNode(last);
            return last;
        }

        public void moveToHead(DLinkedList node){
            removeNode(node);
            addNode(node);
        }
    }
    int capacity;
    int size;
    int minFreq;
    Map<Integer, DLinkedList> caches;
    Map<Integer, LRUQueue> freqs;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        caches = new HashMap<>();
        freqs = new HashMap<>();
        minFreq = 1;
    }

    public int get(int key) {
        //obj not in caches: return -1
        //obj in caches: increase freq. if prev freq has no obj anymore, remove it from freqs map and update minFreq to freq + 1
        DLinkedList node = caches.get(key);
        if(node == null){
            return -1;
        } else {
            int freq = node.freq;
            LRUQueue queue = freqs.get(freq);
            //remove freq from freqs if no more obj associated to it
            queue.removeNode(node);
            if(queue.isEmpty()) {
                freqs.remove(freq);
                //check if we need to update minFreq
                if(freq == minFreq) minFreq++;
            }

            node.freq = freq + 1;
            //update node to new freq list
            LRUQueue newFreqQueue = freqs.getOrDefault(node.freq, new LRUQueue());
            newFreqQueue.addNode(node);
            freqs.put(node.freq, newFreqQueue);

            return node.val;
        }
    }


    public void put(int key, int value) {
        //two cases: obj in the caches or not
        //not in the case: create new dlinkedlist with freq = 1 and insert it into caches, queue, and freqs with freq = 1. update minFreq if
        //necessary. if exceeding capacity, use min freq to get list of objs, and remove the one close to tail of LRU
        //in the case: retrieve node. update val. get list of objs, remove it from original freq list. add node to new freq list. move node to head
        //of LRU
        DLinkedList node = caches.get(key);
        if(node == null){
            //create new
            //insert it into cache
            //get freq queue and insert to it
            //update min freq = min(min_freq, node_freq)
            //check capacity to see if we need to pop one out
            node = new DLinkedList(key, value);
            caches.put(key, node);
            LRUQueue queue = freqs.getOrDefault(1, new LRUQueue());
            queue.addNode(node);
            freqs.put(1, queue);
            size++;
            if(size > capacity){
                LRUQueue olds = freqs.get(minFreq);
                DLinkedList eldest = olds.popTail();
                olds.removeNode(eldest);
                if(olds.isEmpty()) freqs.remove(minFreq);
                caches.remove(eldest.key);
                size--;
            }
            minFreq = Math.min(minFreq, 1);
            return;
        } else {
            //update val
            //increase freq
            //remove it from old freq
            //add it into new freq
            node.val = value;
            int prevFreq = node.freq;
            LRUQueue prevQueue = freqs.get(prevFreq);
            prevQueue.removeNode(node);
            if(prevQueue.isEmpty()) {
                freqs.remove(prevFreq);
                if(prevFreq == minFreq){
                    minFreq++;
                }
            }
            node.freq = prevFreq + 1;
            LRUQueue newQueue = freqs.getOrDefault(node.freq, new LRUQueue());
            newQueue.addNode(node);
            freqs.put(node.freq, newQueue);
            return;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
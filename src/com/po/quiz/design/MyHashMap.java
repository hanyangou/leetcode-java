package com.po.quiz.design;

import java.util.ArrayList;
import java.util.LinkedList;

/***
 * bucket - ArrayList with size of prime number
 * each bucket contains LinkedList of [key,value]
 *
 * follow up Q: load factor
 */
public class MyHashMap {
    class Pair{
        int key;
        int value;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<LinkedList<Pair>> buckets;
    private int SIZE = 2069;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new ArrayList<>();
        for(int i = 0; i < SIZE; i++){
            buckets.add(new LinkedList<>());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        LinkedList<Pair> bucket = getBucket(key);
        if(bucket.size() == 0) bucket.add(new Pair(key, value));
        else {
            boolean found = false;
            for(Pair p : bucket){
                if(p.key == key){
                    p.value = value;
                    found = true;
                    break;
                }
            }
            if(!found) bucket.add(new Pair(key, value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        LinkedList<Pair> bucket = getBucket(key);
        if(bucket.size() == 0) return -1;
        for(Pair p : bucket){
            if(p.key == key) return p.value;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        LinkedList<Pair> bucket = getBucket(key);
        if(bucket.size() == 0) return;
        for(Pair p: bucket){
            if(p.key == key) {
                bucket.remove(p);
                break;
            }
        }
    }

    private LinkedList<Pair> getBucket(int key){
        int hashed = key % SIZE;
        return buckets.get(hashed);
    }
}

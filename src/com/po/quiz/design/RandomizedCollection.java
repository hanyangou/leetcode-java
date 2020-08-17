package com.po.quiz.design;

import java.util.*;

/***
 * be extremely careful the sequence to delete/add value.
 * essential test cases:
 * 1. only one element in the list, remove itself
 */
public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;//[val, set<idx>]
    List<Integer> list;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isContain = map.containsKey(val);
        Set<Integer> set;
        if(isContain){
            set = map.get(val);
        } else {
            set = new HashSet<>();
        }
        int idx = list.size();
        set.add(idx);
        map.put(val, set);
        list.add(val);
        return isContain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        } else {
            Set<Integer> set = map.get(val);
            int idx = set.iterator().next();
            set.remove(idx);
            swap(idx);
            if(set.size() == 0){
                map.remove(val);
            } else {
                map.put(val, set);
            }
            list.remove(list.size() - 1);
            return true;
        }
    }

    //swapping element in list and update idx in map
    private void swap(int idx){
        int lastIdx = list.size() - 1;
        int lastVal = list.get(lastIdx);
        int tmp = list.get(idx);
        list.set(idx, lastVal);
        list.set(lastIdx, tmp);
        Set<Integer> lastSet = map.get(lastVal);
        lastSet.add(idx);
        lastSet.remove(lastIdx);
        map.put(lastVal, lastSet);

    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

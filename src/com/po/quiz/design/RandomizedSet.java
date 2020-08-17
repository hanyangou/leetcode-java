package com.po.quiz.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    Map<Integer, Integer> map; //map[val, idx]
    ArrayList<Integer> list;
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            int idx = list.size();
            list.add(val);
            map.put(val, idx);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int idx = map.get(val);
            //update last value's idx to current since going to swap them
            map.put(list.get(list.size() - 1), idx);
            swap(idx);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
    }

    private void swap(int idx) {
        int tmp = list.get(idx);
        int lastIdx = list.size() - 1;
        int lastVal = list.get(lastIdx);
        list.set(idx, lastVal);
        list.set(lastIdx, tmp);
        map.put(lastVal, idx);
        map.put(tmp, lastIdx);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}

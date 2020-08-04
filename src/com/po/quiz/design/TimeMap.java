package com.po.quiz.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    Map<String, List<Pair>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> pairs = map.computeIfAbsent(key, k-> new ArrayList<>());
        pairs.add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = map.get(key);
        if(pairs == null) return "";
        Pair p = getPair(pairs, timestamp);
        return p == null ? "" : p.value;
    }
    //binary search to get pair
    public Pair getPair(List<Pair> pairs, int timestamp){
        int left = 0, right = pairs.size() - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int ts = pairs.get(mid).timestamp;
            if(ts == timestamp)
                return pairs.get(mid);
            else if(ts < timestamp){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(left == 0) return null;
        else return pairs.get(right);
    }

    class Pair{
        int timestamp;
        String value;
        public Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

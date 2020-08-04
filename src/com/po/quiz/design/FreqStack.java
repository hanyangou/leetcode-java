package com.po.quiz.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FreqStack {
    PriorityQueue<Pair> pq;
    Map<Integer, Pair> map;
    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<Pair>((p1,p2) ->{
            int freq1 = p1.freq;
            int freq2 = p2.freq;
            return Integer.compare(freq2, freq1);
        });
    }

    public void push(int x) {
        Pair p = map.getOrDefault(x, new Pair(x));
        if(map.containsKey(x)){
            pq.remove(p);
            p.freq = p.freq + 1;
        }
        pq.add(p);
    }

    public int pop() {
        Pair p = pq.poll();
        if(p.freq == 1){
            map.remove(p);
        } else {
            p.freq = p.freq - 1;
            pq.add(p);
        }
        return p.val;
    }

    class Pair{
        int val;
        int freq;
        public Pair(int val){
            this.val = val;
            freq = 1;
        }
    }
}

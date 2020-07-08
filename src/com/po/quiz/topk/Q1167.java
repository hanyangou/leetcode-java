package com.po.quiz.topk;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1167 {
    public int connectSticks(int[] sticks) {
        if(sticks.length == 1) return 0;
        Arrays.sort(sticks);
        int sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < sticks.length; i++) pq.add(sticks[i]);
        while (pq.size() > 1){
            int s1 = pq.poll();
            int s2 = pq.poll();
            int cost = s1 + s2;
            sum+= cost;
            pq.add(cost);
        }
        return sum;
    }
}

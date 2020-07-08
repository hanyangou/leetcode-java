package com.po.quiz.topk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/***
 * challenge: negative number?
 * priority queue... who places at head?
 */
public class Q658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i1, i2) ->{
            int diff = Math.abs(i2 - x) - Math.abs(i1 - x);
            if(diff == 0) return i2 - i1;
            else return diff;
        });
        for(int i : arr) {
            pq.add(i);
            if(pq.size() > k) pq.poll();
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll());
        Collections.sort(res);
        return res;
    }
}

package com.po.quiz.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones) heap.add(stone);

        while(heap.size() > 1){
            int stone1 = heap.remove();
            int stone2 = heap.remove();
            int smash = Math.abs(stone1 - stone2);
            if(smash > 0) heap.add(smash);
        }

        return heap.isEmpty() ? 0 : heap.remove();
    }
}

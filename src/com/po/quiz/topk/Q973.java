package com.po.quiz.topk;

import java.util.PriorityQueue;

public class Q973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((d1,d2) -> getDistance(d2).compareTo(getDistance(d1)));
        for(int[] p : points){
            heap.add(p);
            if(heap.size() > K) heap.poll();
        }
        int[][] res = new int[K][2];
        int idx = 0;
        while (!heap.isEmpty()) res[idx++] = heap.poll();
        return res;
    }

    public Double getDistance(int[] loc){
        return Math.sqrt(loc[0]*loc[0] + loc[1]*loc[1]);
    }
}

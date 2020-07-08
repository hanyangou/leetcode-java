package com.po.quiz.sweepline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Q218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for(int[] b : buildings){
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (p1,p2) -> {
            if(p1[0] != p2[0])
                return p1[0] - p2[0];
            else
                return p1[1] - p2[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((h1,h2) -> { //reverse order of natural ordering
            return h2 - h1;
        });
        pq.offer(0);
        List<List<Integer>> res = new ArrayList<>();
        int max = 0;
        for(int[] h : heights){
            if(h[1] < 0) { //start point
                int height = -h[1];
                pq.offer(height);
                if(height > max){
                    max = height;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(h[0]);
                    tmp.add(height);
                    res.add(tmp);
                }
            } else { //end point
                int height = h[1];
                pq.remove(height);
                if(max == height){
                    int nextMax = pq.peek();
                    max = nextMax;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(h[0]);
                    tmp.add(nextMax);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}

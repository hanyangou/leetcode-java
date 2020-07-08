package com.po.quiz.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/***
 * Dijstra's algorithm to find the shortest path for each node
 */
public class Q734 {
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((i1, i2) -> i1[0] - i2[0]); //[weight, node]
        for(int[] time : times){
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            ArrayList<int[]> toList = graph.getOrDefault(from, new ArrayList<>());
            toList.add(new int[]{weight, to});
            graph.put(from, toList);
        }
        queue.offer(new int[]{0, K});
        boolean[] visit = new boolean[N];
        int maxDelay = 0;
        int numOfVisitedNode = 0;
        while (!queue.isEmpty()){
            int[] pair = queue.remove();
            int node = pair[1];
            if(visit[node -1]) continue;

            numOfVisitedNode++;
            int weight = pair[0];
            maxDelay = Math.max(maxDelay, weight);
            visit[node - 1] = true;
            if(graph.containsKey(node)){
                ArrayList<int[]> nexts = graph.get(node);
                for(int[] n : nexts){
                    queue.offer(new int[]{weight + n[0], n[1]});
                }
            }
        }

        return numOfVisitedNode == N ? maxDelay : -1;
    }
}

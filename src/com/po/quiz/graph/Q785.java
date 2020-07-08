package com.po.quiz.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * using color indicating the campaign it belongs to
 * island?
 */
public class Q785 {
    public boolean isBipartite(int[][] graph) {
        if(graph.length == 1) return true;

        int[] colors = new int[graph.length]; //0 not visited, 1, and -1
        for(int i = 0; i < graph.length; i++){
            if(colors[i] != 0) continue; //visited already, skip it
            colors[i] = 1;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(i);
            while (!stack.isEmpty()){
                Integer node = stack.pop();
                int c = colors[node];
                for(int n: graph[node]){
                    if(colors[n] == c) return false;
                    if(colors[n] == 0){
                        colors[n] = c * -1;
                        stack.push(n);
                    }
                }
            }
        }
        return true;
    }
}

/***

 public boolean isBipartite(int[][] graph) {
 //corner case: []
 if(graph.length == 1) return true;

 int[] colors = new int[graph.length];
 Queue<Set<Integer>> queue = new LinkedList<>();
 int color = 1;//color : 1 or -1.
 boolean[] visited = new boolean[graph.length];


 for(int c = 0; c < graph.length; c++){
 if(visited[c]) continue;
 Set<Integer> set = new HashSet<>();
 set.add(c);
 queue.offer(set);
 while (!queue.isEmpty()){
 Set<Integer> nodes = queue.poll();
 Set<Integer> nexts = new HashSet<>();
 for(int n : nodes){
 for(int i : graph[n]) {
 if(colors[i] == color) return false;
 if(!visited[i]) nexts.add(i);
 }
 visited[n] = true;
 colors[n] = color;
 }
 if(nexts.size() > 0) queue.offer(nexts);
 color = color * -1;
 }
 }
 return true;
 }
***/
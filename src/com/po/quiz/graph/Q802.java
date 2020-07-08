package com.po.quiz.graph;

import java.util.*;

/***
 * there are two approaches for this question: checking from eventual safe nodes and doing reverse travel
 * OR
 * finding cycle in the graph
 *
 * finding cycle: can use white/gray/black DFS algo
 *
 *
 * for reverse checking:
 * how to manage bidirectional graph efficiently? forward (direction) and reverse map
 *
 */
public class Q802 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        return colorDFS(graph);
    }

    public List<Integer> colorDFS(int[][] graph){
        int[] colors = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!isCycle(i, colors, graph)) ans.add(i);
        }

        return ans;
    }

    //white:0, gray:1, black:2
    public boolean isCycle(int node, int[] colors, int[][] graph){
        //terminate condition: encounter nodes that are not in white. if it is black then no cycle. if it is gray then there is cycle
        if(colors[node] > 0) {
            return colors[node] == 1;
        }
        colors[node] = 1;
        for(int adj : graph[node]){
            if(!isCycle(adj, colors, graph)){
                continue;
            } else {
                return true;
            }
        }
        colors[node] = 2;
        return false;
    }

    public List<Integer> reverseEdge(int[][] graph){
        //corner case
        List<Set<Integer>> forwards = new ArrayList<>();
        List<Set<Integer>> reverses = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            forwards.add(new HashSet<>());
            reverses.add(new HashSet<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        //building relationships
        for(int i = 0; i < graph.length; i++){
            if(graph[i].length == 0) queue.offer(i);
            else {
                for(int edge : graph[i]){
                    forwards.get(i).add(edge);
                    reverses.get(edge).add(i);
                }
            }
        }
        while (!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            Set<Integer> inbounds = reverses.get(node);
            for(int inbound : inbounds){
                Set<Integer> forwardSet = forwards.get(inbound);
                forwardSet.remove(node);
                if(forwardSet.isEmpty()) queue.offer(inbound);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

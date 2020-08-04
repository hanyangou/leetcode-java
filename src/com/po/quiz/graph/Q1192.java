package com.po.quiz.graph;

import java.util.*;

public class Q1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //building graph
        Set<List<Integer>> edges = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(List<Integer> conn : connections){
            if(conn.get(0) > conn.get(1)){ //swap the elements to make sure e[0] <= e[1]
                int tmp = conn.get(0);
                conn.set(0, conn.get(1));
                conn.set(1, tmp);
            }
            edges.add(conn);
            int n1 = conn.get(0);
            int n2 = conn.get(1);
            List<Integer> list1 = graph.computeIfAbsent(n1, k -> new ArrayList<>());
            list1.add(n2);
            List<Integer> list2 = graph.computeIfAbsent(n2, k-> new ArrayList<>());
            list2.add(n1);
        }
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, edges, rank, 0, 0);
        return new ArrayList<>(edges);
    }

    public int dfs(Map<Integer, List<Integer>> graph, Set<List<Integer>> edges, int[] rank, int node, int height){
        if(rank[node] >= 0) return rank[node]; //if this node has been visited before, just return its rank
        rank[node] = height;
        int minHeight = height;
        List<Integer> neighbors = graph.get(node);
        for(int n : neighbors){
            if(rank[n] == height - 1) continue; //skip the neighbor with prev rank
            int minRank = dfs(graph, edges, rank, n, height + 1);
            minHeight = Math.min(minRank, minHeight);
            if(minRank <= height){
                edges.remove(Arrays.asList(Math.min(n, node),Math.max(n, node)));
            }
        }
        return minHeight;
    }
}

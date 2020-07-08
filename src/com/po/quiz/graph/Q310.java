package com.po.quiz.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 *  1. build graph Map<from, [to]>
 *  2. remove leaves one by one
 ***/
public class Q310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //corner case: n = 0 or 1
        if(n == 0) return new ArrayList<>();
        if(n <= 2) {
            ArrayList<Integer> res = new ArrayList<>();
            for(int i = 0; i < n; i++) res.add(i);
            return res;
        }

        ArrayList<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new HashSet<>());

        for (int[] e : edges) {
            int n1 = e[0];
            int n2 = e[1];
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        int pruned = 0;
        while (n - pruned > 2) {
            ArrayList<Integer> newLeaves = new ArrayList<>();
            pruned += leaves.size();
            for (Integer leaf : leaves) {
                Set<Integer> neighbors = graph.get(leaf);
                for (Integer neighbor : neighbors) {
                    graph.get(neighbor).remove(leaf);
                    if(graph.get(neighbor).size() == 1) newLeaves.add(neighbor);
                    graph.get(leaf).remove(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}

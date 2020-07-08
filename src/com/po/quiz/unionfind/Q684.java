package com.po.quiz.unionfind;

import java.util.Arrays;

public class Q684 {
    //cyclic detection
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        if(edges == null || edges.length == 0) return ans;
        int max = Integer.MIN_VALUE;
        for(int[] edge : edges){
            for(int i : edge){
                max = Math.max(i, max);
            }
        }
        int[] parents = new int[max + 1];

        Arrays.fill(parents, -1);
        for(int[] edge : edges){
            if(find(parents, edge[0]) == find(parents, edge[1]) && find(parents, edge[0]) != -1){
                ans[0] = edge[0];
                ans[1] = edge[1];
                return ans;
            } else {
                union(parents, edge[0], edge[1]);
            }

        }
        return ans;
    }

    private void union(int[] parent, int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    private int find(int[] parent, int x){
        if(parent[x] == -1)
            return x;
        return find(parent, parent[x]);
    }
}

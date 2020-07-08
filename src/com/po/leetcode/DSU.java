package com.po.leetcode;

/***
 * implementing Disjoint Set aka Union Find
 */
public class DSU {
    public static void union(int[] parent, int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        if(xset != yset)
            parent[xset] = yset;

    }

    public static int find(int[] parent, int x){
        int p = parent[x];
        if(p == -1)
            return x;
        return find(parent, p);
    }
}

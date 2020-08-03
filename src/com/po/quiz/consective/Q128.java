package com.po.quiz.consective;

import java.util.*;

public class Q128 {
    class UnionSet{
        int[] parents;
        int[] ranks;
        public UnionSet(int n){
            parents = new int[n];
            ranks = new int[n];
            for(int i = 0; i < n; i++)
                parents[i] = i;
            Arrays.fill(ranks, 1);
        }

        public int union(int a, int b){
            int idxA = find(a);
            int idxB = find(b);
            if(idxA == idxB)
                return -1;
            if(ranks[idxA] > ranks[idxB]){
                parents[idxB] = idxA;
                ranks[idxA] += ranks[idxB];
                return ranks[idxA];
            } else {
                parents[idxA] = idxB;
                ranks[idxB] += ranks[idxA];
                return ranks[idxB];
            }
        }

        public int find(int a){
            //path compression
            if(parents[a] != a)
                parents[a] = find(parents[a]);
            return parents[a];
        }
    }


    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> idx = new HashMap<>();
        UnionSet us = new UnionSet(nums.length);
        int ans = 1;
        for(int i = 0; i < nums.length; i++){
            int e = nums[i];
            if(idx.containsKey(e)) continue;
            idx.put(e, i);
            if (idx.containsKey(e - 1)){
                ans = Math.max(ans, us.union(i, idx.get(e-1)));
            }
            if(idx.containsKey(e+1)){
                ans = Math.max(ans, us.union(i, idx.get(e+1)));
            }
        }
        return ans;
    }
}

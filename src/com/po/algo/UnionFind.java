package com.po.algo;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    Map<Integer, Integer> union;
    public UnionFind(){
        union = new HashMap<>();
    }

    public void union(Integer child, Integer parent){
        Integer c = find(child);
        Integer p = find(parent);
        union.put(c, p);
    }

    public Integer find(Integer target){
        Integer parent = union.getOrDefault(target, target);
        return parent.equals(target) ? parent : find(parent);
    }
}

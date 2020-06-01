package com.po.quiz.string;

import java.util.*;

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String sorted = String.valueOf(ca);
            List<String> group = map.getOrDefault(sorted, new ArrayList<>());
            group.add(str);
            map.put(sorted, group);
        }
        return new ArrayList<>(map.values());
    }
}

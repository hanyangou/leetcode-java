package com.po.quiz.string;

import java.util.HashMap;
import java.util.Map;

public class Q76 {
    public String minWindow(String s, String t) {
        //corner case: s and t
        Map<Character, Integer> totals = new HashMap<>();
        for (char c : t.toCharArray()) {
            Integer total = totals.getOrDefault(c, 0);
            totals.put(c, total + 1);
        }
        int len = 0, left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int[] pair = new int[2];
        while (left < s.length() && !totals.containsKey(s.charAt(left))) {
            left++;
        }
        right = left;
        Map<Character, Integer> occrs = new HashMap<>();
        while (right < s.length()){
            char c = s.charAt(right);
            if(totals.containsKey(c)){
                //int occr = occrs
            }

        }

        return min == Integer.MAX_VALUE ? "" : s.substring(pair[0], pair[1]);
    }
}


//some cases:
//s or t null
//s has no substring that contains t
//some characters showing multiple times in substring window
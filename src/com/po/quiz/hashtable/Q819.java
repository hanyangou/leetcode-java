package com.po.quiz.hashtable;

import java.util.*;

public class Q819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> ban = new HashSet<>();
        for(String b: banned) //O(B.size())
            ban.add(b);
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        String splitter = "!?',;.";
        List<String> list = new ArrayList<>();
        while(idx < paragraph.length()){
            char c = paragraph.charAt(idx++);
            if(c == '.' || c == '!' || c == '?' || c == '\'' || c == ',' || c ==';' || c == ' '){
                if(sb.length() > 0){
                    list.add(sb.toString().toLowerCase());
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(c);
            }
        }
        if(sb.length() > 0)
            list.add(sb.toString().toLowerCase());
        int max = 0;
        String ans = "";
        for(int i = 0; i < list.size(); i++){ //O(# of words)
            if(!ban.contains(list.get(i))){
                int count = map.getOrDefault(list.get(i), 0) + 1;
                map.put(list.get(i), count);
                if(count > max){
                    max = count;
                    ans = list.get(i);
                }
            }
        }
        return ans;
    }
}

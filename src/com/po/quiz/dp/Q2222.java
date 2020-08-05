package com.po.quiz.dp;

import java.util.*;

public class Q2222 {
    Set<String> dict;
    Set<String> dp;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        dict = new HashSet<>();
        dp = new HashSet<>();
        List<String> res = new ArrayList<>();
        if(words.length == 0) return res;
        Arrays.sort(words, (s1,s2) -> {
            if(s1.length() == s2.length())
                return s1.compareTo(s2);
            else return Integer.compare(s1.length(), s2.length());
        });
        for(String s : words){
            if(!s.isEmpty() && isConcatenated(s, 0)){
                res.add(s);
                dp.add(s);
            }
            dict.add(s);
        }
        return res;
    }

    public boolean isConcatenated(String s, int start){
        if(start == s.length()) return true;
        if(dp.contains(s)){
            return true;
        }
        for(int end = start + 1; end <= s.length(); end++){
            String prefix = s.substring(start, end);
            if(dict.contains(prefix)){
                if(isConcatenated(s, end)){
                    return true;
                }
            }
        }
        return false;
    }
}
package com.po.quiz.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q140 {
    Map<String, List<String>> memo; //[string, sentences]
    List<String> wordDict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        return bottomupapproach(s, wordDict);
    }

    /***
     * Bottom-Up approach
     */
    public List<String> bottomupapproach(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        return bottomup(s, new HashMap<>());
    }

    /***
     * end: dp for s(0:end) which end is inclusive
     * algo:
     * 1. dp[end] = (dp[end-x] + w) + s (if wd.contains(s)), if wd.contains(w), x = 0 : i - 1
     * 2. terminate when i == s.length
     */
    public List<String> bottomup(String s, Map<Integer, List<String>> dp){
//        //terminate case????
//        if(dp.containsKey(end)){
//            return dp.get(end);
//        }
        for(int i = 0; i < s.length(); i++){
            String substring = s.substring(0, i+1);
            List<String> l = dp.getOrDefault(substring, new ArrayList<>());
            //building sentences from previous dp
            for(int j = 0; j < i; j++){
                String postfix = s.substring(j+1, i+1);
                List<String> prev = dp.getOrDefault(j, new ArrayList<>());
                if(wordDict.contains(postfix) && prev.size() > 0){
                    for(String p : prev){
                        l.add(p + " " + postfix);
                    }
                }
            }
            //checking if whole substring can make a sentence
            if(wordDict.contains(substring)){
                l.add(substring);
            }
            dp.put(i, l);
        }
        return dp.get(s.length() - 1);
    }
    /***
     * Top-Down approach
     */

    public List<String> topdown(String s, List<String> wordDict) {
        memo = new HashMap<>();
        this.wordDict = wordDict;
        return dp(s);
    }
    //returning all possible sentences for given string
    public List<String> dp(String s){
        if(s == null || s.isEmpty()){
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        if(memo.containsKey(s)){
            return memo.get(s);
        } else {
            List<String> sentences = new ArrayList<>();
            for(int i = 0; i < s.length(); i++){
                String prefix = s.substring(0, i + 1);
                if(wordDict.contains(prefix)){
                    List<String> nextSen = dp(s.substring(i+1));
                    for(String sen : nextSen){
                        if(sen.isEmpty())
                            sentences.add(prefix);
                        else
                            sentences.add(prefix + " " + sen);
                    }
                }
            }
            memo.put(s, sentences);
            return sentences;
        }
    }
}

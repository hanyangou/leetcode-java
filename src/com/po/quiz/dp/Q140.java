package com.po.quiz.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q140 {
    Map<String, List<String>> memo; //[string, sentences]
    List<String> wordDict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        this.wordDict = wordDict;
        return dp(s);
    }

    //returning all possible sentences for given string
    public List<String> dp(String s){
        //base: need to return empty string instead of empty list to differentiate from no result
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

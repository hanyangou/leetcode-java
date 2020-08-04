package com.po.quiz.bfs;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //preprocess
        Map<String, List<String>> fromWild = new HashMap<>();
        Map<String, List<String>> toWild = new HashMap<>();
        wordList.add(beginWord);
        for(String word : wordList){
            for(int i = 0; i < word.length(); i++){
                String wild = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> list = fromWild.computeIfAbsent(wild, k -> new ArrayList<>());
                list.add(word);
                List<String> wilds = toWild.computeIfAbsent(word, k -> new ArrayList<>());
                wilds.add(wild);
            }
        }
        //bfs
        int len = 0;
        Set<String> seen = new HashSet<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord, 1));
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            if(seen.contains(p.s)) continue;
            int rank = p.rank + 1;
            seen.add(p.s);
            List<String> wilds = toWild.getOrDefault(p.s, new ArrayList<>());
            for(String w : wilds){
                List<String> neighbors = fromWild.get(w);
                for(String n : neighbors){
                    if(n.equals(endWord))
                        return rank;
                    else {
                        queue.add(new Pair(n, rank));
                    }
                }
            }
        }
        return 0;
    }

    class Pair{
        String s;
        int rank;
        public Pair(String s, int rank){
            this.s = s;
            this.rank = rank;
        }
    }
}

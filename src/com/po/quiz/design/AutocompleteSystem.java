package com.po.quiz.design;

import java.util.*;

/***
 * challenges: 1) constructing trie 2) getting all candidates -- traveling with all branches in trie
 */

public class AutocompleteSystem {
    Trie root;
    Map<String, Integer> counts;
    StringBuffer buf;
    Trie current;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie('a');
        counts = new HashMap<>();
        buf = new StringBuffer();
        current = root;
        for(int i = 0; i < sentences.length; i++){
            String s = sentences[i];
            insert(s);
            counts.put(s, times[i]);
        }
        return;
    }

    public void insert(String sentences){
        Trie cur = root;
        for(char c : sentences.toCharArray()){
            cur = cur.insertNext(c);
        }
        cur.isEnd = true;
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        //check if c == '#'
        if(c == '#'){
            String s = buf.toString();
            insert(s);
            counts.put(s, counts.getOrDefault(s, 0) + 1);
            buf.setLength(0);
            current = root;
        } else {
            buf.append(c);
            if(current != null)
                current = current.getNext(c);
            if(current != null){
                if(current.isEnd)
                    res.add(buf.toString());
                Trie next = current;
                Deque<Pair> stack = new ArrayDeque<>();
                List<Trie> candidates = next.getCandidates();
                for(Trie t: candidates)
                    stack.push(new Pair(t, new StringBuffer(buf)));
                while (!stack.isEmpty()){
                    Pair p = stack.pop();
                    next = p.t;
                    StringBuffer sb = p.sb;
                    sb.append(next.c);
                    if(next.isEnd){
                        res.add(sb.toString());
                    }
                    List<Trie> children = next.getCandidates();
                    //optimization starts
                    while (children.size() == 1){
                        next = children.get(0);
                        sb.append(next.c);
                        if(next.isEnd){
                            res.add(sb.toString());
                        }
                        children = next.getCandidates();
                    }
                    //optimization ends
                    for(Trie child : children)
                        stack.push(new Pair(child, new StringBuffer(sb)));
                }
            }
        }
        Collections.sort(res, (s1, s2) ->{
            int c1 = counts.get(s1);
            int c2 = counts.get(s2);
            if(c1 == c2){
                return s1.compareTo(s2);
            } else {
                return Integer.compare(c2, c1);
            }
        });

        while (res.size() > 3)
            res.remove(res.size() - 1);
        return res;
    }

    class Pair{
        Trie t;
        StringBuffer sb;
        public Pair(Trie t, StringBuffer sb){
            this.t = t;
            this.sb = new StringBuffer(sb);
        }
    }

    class Trie{
        char c;
        Map<Character, Trie> nodes;
        boolean isEnd;
        Trie(char c){
            this.c = c;
            nodes = new HashMap<>();
            isEnd = false;
        }

        public List<Trie> getCandidates(){
            return new ArrayList<>(nodes.values());
        }

        public Trie getNext(char next){
            return nodes.get(next);
        }

        public boolean hasNext(){
            return nodes.size() > 0;
        }

        //only insert if node for next does not exist yet
        public Trie insertNext(char next){
            Trie node = nodes.get(next);
            if(node == null){
                node = new Trie(next);
                nodes.put(next, node);
            }
            return node;
        }
    }
}

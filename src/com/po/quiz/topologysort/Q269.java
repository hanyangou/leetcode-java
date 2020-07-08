package com.po.quiz.topologysort;

import java.util.*;

/***
 * 1. extract relationship from example
 * 2. representing relationships
 */
public class Q269 {
    public String alienOrder(String[] words) {
        //1. extracting information from given words
        Set<List<Character>> dependencies = extract(words);
        //invalid order, return empty string
        if (dependencies == null) return "";
        //2. representing relationship
        Map<Character, Set<Character>> adjs = new HashMap<>(); //graph for [from, set[to]]
        Map<Character, Integer> counts = new HashMap<>(); //count of inbounds
        for(String word : words){
            for(char c : word.toCharArray()){
                adjs.put(c, new HashSet<>());
                counts.put(c, 0);
            }
        }

        for(List<Character> list : dependencies){
            char from = list.get(0);
            char to = list.get(1);
            if(adjs.get(to).contains(from)) return "";
            Set<Character> adj = adjs.get(from);
            adj.add(to);
            adjs.put(from, adj);
            counts.put(to, counts.get(to) + 1);
        }
        //iterate the nodes without inbound
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> e : counts.entrySet()){
            if(e.getValue().equals(0)){
                queue.offer(e.getKey());
            }
        }
        while (!queue.isEmpty()){
            Character c = queue.poll();
            sb.append(c);
            Set<Character> adj = adjs.get(c);
            for(Character to : adj){
                Integer count = counts.get(to);
                count--;
                counts.put(to, count);
                if(count.equals(0)) queue.offer(to);
            }
        }

        return sb.toString();
    }

    /***
     * compare alphabet at each of position one by one.
     * some cases:
     * 1. w1 is prefix of w2: abc, abcde -> giving no info
     * 2. w2 is prefix of w1: abcde, abc -> invalid case, indicating the order is invalid
     * 3. w1 or w2 is empty: "", abc OR abc, "" -> giving no info
     * 4. regular case
     */
    public Set<List<Character>> extract(String[] words) {
        Set<List<Character>> lists = new HashSet<>();
        //compare two words until the last two words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1 == null || w1.length() == 0 || w2 == null || w2.length() == 0) continue;
            //invalid order, return null
            if (w1.length() <= w2.length() && w2.indexOf(w1) == 0) continue;
            if (w1.length() > w2.length() && w1.indexOf(w2) == 0) return null;

            List<Character> order = new ArrayList<>();
            int j = 0;
            while (j < Math.min(w1.length(), w2.length()) && w1.charAt(j) == w2.charAt(j)) j++;
            order.add(w1.charAt(j));
            order.add(w2.charAt(j));
            lists.add(order);
        }
        return lists;
    }
}

/***
     * archieved codes
     *

    public String alienOrder(String[] words) {
        //1. extracting information from given words
        Set<List<Character>> dependencies = extract(words);
        //invalid order, return empty string
        if (dependencies == null) return "";
        //2. representing relationships
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1); //-1 means the character does not appear
        Map<Character, List<Character>> map = new HashMap<>();
        buildTopology(map, indegree, dependencies);

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer((char) (i + 'a'));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);
            List<Character> dependents = map.get(c);
            if (dependents != null && dependents.size() != 0) {
                for (Character d : dependents) {
                    indegree[d - 'a'] = indegree[d - 'a'] - 1;
                    if (indegree[d - 'a'] == 0) queue.offer(d);
                }
            }
        }
        return sb.toString();
    }

    public void buildTopology(Map<Character, List<Character>> map, int[] indegree, List<List<Character>> dependencies) {
        for (List<Character> list : dependencies) {
            Character before = list.get(0);
            Character after = list.get(1);

            if (indegree[before - 'a'] == -1) indegree[before - 'a'] = 0;

            if (before != after) {
                int degree = indegree[after - 'a'];
                if (degree == -1)
                    indegree[after - 'a'] = 1;
                else
                    indegree[after - 'a'] = indegree[after - 'a'] + 1;

                List<Character> dependents = map.getOrDefault(before, new ArrayList<>());
                dependents.add(after);
                map.put(before, dependents);
            }
        }
    }

    public Set<List<Character>> extract(String[] words) {
        Set<List<Character>> lists = new HashSet<>();
        //compare two words until the last two words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1 == null || w1.length() == 0 || w2 == null || w2.length() == 0) continue;
            //invalid order, return null
            if (w1.length() < w2.length() && w2.contains(w1)) return null;
            if (w1.length() > w2.length() && w1.contains(w2)) continue;

            List<Character> order = new ArrayList<>();
            int j = 0;
            while (j < Math.min(w1.length(), w2.length()) && w1.charAt(j) == w2.charAt(j)) j++;
            order.add(w1.charAt(j));
            order.add(w2.charAt(j));
            lists.add(order);
        }
        return lists;
    }
*/
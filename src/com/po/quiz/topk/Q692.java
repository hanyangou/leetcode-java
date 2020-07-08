package com.po.quiz.topk;

import java.util.*;

/***
 * non-empty -> no corner case
 * 1) sort from high to low -> priority queue
 * 2) sort with alphabet order
 *
 * tuple: left:keyword, right: freq
 * priority queue for tuple : t1.right > t2.right , t1.key > ti.key (java string comparision?) string.compareTo? ??
 *
 */
public class Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                if(o1.freq == o2.freq){
                    return o1.str.compareTo(o2.str);
                } else {
                    return o2.freq - o1.freq;
                }
            }
        });

        Map<String, Integer> freqs = new HashMap<>();
        for(String w : words){
            Integer freq = freqs.getOrDefault(w, 0);
            freqs.put(w, freq + 1);
        }
        for(Map.Entry e : freqs.entrySet()){
            Tuple t = new Tuple(String.valueOf(e.getKey()), (int)e.getValue());
            pq.offer(t);
        }

        List<String> ans = new ArrayList<>();
        while (k > 0){
            ans.add(pq.poll().str);
            k--;
        }
        return ans;
    }

    class Tuple {
        String str;
        int freq;
        //public Tuple(){};
        public Tuple(String str, int freq){
            this.str = str;
            this.freq = freq;
        };
    }
}

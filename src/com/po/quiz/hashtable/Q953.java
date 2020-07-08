package com.po.quiz.hashtable;

public class Q953 {
    public boolean isAlienSorted(String[] words, String order) {
        //corner base

        //Map<Character, Integer> mapper = new HashMap<>();
        int[] mapper = new int[26];
        //building order in hashmap. O(m), m = order.length
        for(int i = 0; i < order.length(); i++){
            mapper[order.charAt(i) - 'a'] = i;
        }

        //comparing words two by two. O(n), n = words.length
        //for each loop, comparing character one by one. take O(k), k is avg length of word
        //total O(n*k)
        //iterating to the character that is different
        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            if(w1.length() > w2.length() && w1.contains(w2)) return false; //w2 is prefix of w1, invalid
            if(w2.length() > w1.length() && w2.contains(w1)) continue; //w1 is prefix. valid
            int j = 0;
            while (j < Math.min(w1.length(), w2.length()) && w1.charAt(j) == w2.charAt(j)){
                j++;
            }
            if(mapper[w2.charAt(j) - 'a'] < mapper[w1.charAt(j) - 'a']) return false;
        }
        return true;
    }
}

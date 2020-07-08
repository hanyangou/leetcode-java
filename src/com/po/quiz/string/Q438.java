package com.po.quiz.string;

import java.util.ArrayList;
import java.util.List;

public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] counter = new int[26];
        for(Character c : p.toCharArray()){
            counter[c - 'a']++;
        }
        for(int i = 0; i < counter.length; i++){
            if(counter[i] == 0) counter[i] = -1;
        }
        //List<Character> records = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int length = 0;
        int left = 0;
        int right = 0;
        while (left < s.length() && right < s.length()){
            char c = s.charAt(right); //sliding right until condition is not hold
            counter[c - 'a']--;
            length++;
            if(length == p.length()){
                res.add(left);
            }
            if(counter[c - 'a'] == -1){ //too many c, moving left until c = 0
                while (counter[c - 'a'] == -1){
                    int lc = s.charAt(left);
                    counter[lc - 'a']++;
                    left++;
                    length--;
                }
            }
            if(counter[c - 'a'] == -2){
                while (left <= right){
                    int lc = s.charAt(left);
                    counter[lc - 'a']++;
                    left++;
                    length--;
                }
            }
            right++;
        }
        return res;
    }
}

package com.po.quiz.string;

import java.util.HashSet;
import java.util.Set;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalidPos = new HashSet<>();
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') balance++;
            else if (s.charAt(i) == ')') {
                if (balance < 0) invalidPos.add(i);
                else balance--;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (balance == 0) break;
            if (s.charAt(i) == '(') {
                invalidPos.add(i);
                balance--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!invalidPos.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

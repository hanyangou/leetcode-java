package com.po.quiz.puzzle;

import java.util.LinkedList;

public class Q38 {
    public String countAndSay(int n) {
        if(n == 0) return "";
        if(n == 1) return "1";
        LinkedList<Integer> init = new LinkedList<>();
        init.add(1);
        init.add(-1);//delimeter that trigger seq addition
        LinkedList<Integer> seq = nextSequence(n, init);
        StringBuilder sb = new StringBuilder();
        for(Integer i : seq)
            sb.append(i);
        return sb.toString();
    }

    public LinkedList<Integer> nextSequence(int n, LinkedList<Integer> prev){
        if(n <= 1){
            prev.pollLast();
            return prev;
        }
        LinkedList<Integer> next = new LinkedList<>();
        Integer prevDigit = null;
        Integer prevCount = 0;
        for(Integer i : prev){
            if(prevDigit == null){
                prevDigit = i;
                prevCount++;
            } else if(prevDigit.equals(i)){
                prevCount++;
            } else {
                next.add(prevCount);
                next.add(prevDigit);
                prevDigit = i;
                prevCount = 1;
            }
        }
        next.add(-1);
        return nextSequence(n - 1, next);
    }
}

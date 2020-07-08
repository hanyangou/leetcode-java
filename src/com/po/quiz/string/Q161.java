package com.po.quiz.string;

public class Q161 {
    public boolean isOneEditDistance(String s, String t) {
        //corner case
        int lens = s.length();
        int lent = t.length();
        if(lens > lent) return isOneEditDistance(t, s);

        if(lent - lens > 1) return false;
        for(int i = 0; i < lens; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(lens == lent){
                    return s.substring(i+1).equals(t.substring(i+1));
                } else {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return lens + 1 == lent;
    }
}

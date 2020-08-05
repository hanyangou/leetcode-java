package com.po;


import com.po.quiz.dp.Q2222;

public class Main {

    public static void main(String[] args) {
        String[] strs = new String[]{"cat","cats","catsdogcats","dog"};
        Q2222 q = new Q2222();
        q.findAllConcatenatedWordsInADict(strs);
    }

    public static String ip(String ip){




        int dot = 0;
        for(char c : ip.toCharArray()){
            if(c == '.') dot++;
        }
        if(dot == 3) return "ip4";
        int colon = 0;
        for(char c : ip.toCharArray()){
            if(c == ':') colon++;
        }
        if(colon == 7) return "ip6";
        return "Neither";

    }

    public static void print(String str){
        System.out.println(str);
    }
}

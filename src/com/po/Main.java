package com.po;


import com.po.quiz.dp.Q140;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Q140 q = new Q140();
        List<String> list = Arrays.asList(new String[]{"aaaa","aa","a"});
        q.wordBreak("aaaaaaa", list);
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

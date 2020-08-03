package com.po;

import com.po.quiz.bfs.Q127;
import com.po.quiz.calculator.Q772;
import com.po.quiz.design.AutocompleteSystem;
import com.po.quiz.design.FileSystem;
import com.po.quiz.dp.Q140;
import com.po.quiz.dp.Q85;
import com.po.quiz.heap.Q4;
import com.po.quiz.string.Q68;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Q140 q = new Q140();
        List<String> list = Arrays.asList(new String[]{"cat","cats","and","sand","dog"});
        q.wordBreak("catsanddog", list);
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

package com.po;


import com.po.quiz.segmenttree.Q315;

public class Main {

    public static void main(String[] args) {
        int[] input = new int[]{5,2,6,1};
        Q315 q = new Q315();
        q.countSmaller(input);
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

package com.po;

import com.po.quiz.design.AutocompleteSystem;

public class Main {

    public static void main(String[] args) {
        String[] input1 = new String[]{"i love you","island","ironman","i love leetcode"};
        int[] input2 = new int[]{5,3,2,2};
        AutocompleteSystem system = new AutocompleteSystem(input1, input2);
        system.input('i');
        system.input(' ');
        system.input('a');
        system.input('#');
        system.input('i');
        system.input(' ');
        system.input('a');
        system.input('#');

        
        
        print(ip("120.0.0.1"));
        print(ip("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        print(ip("123.0.0"));
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

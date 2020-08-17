package com.po;

import com.po.quiz.design.RandomizedCollection;
import com.po.quiz.design.RandomizedSet;

public class Main {

    public static void main(String[] args) {
        RandomizedCollection set = new RandomizedCollection();
        set.insert(0);
        set.remove(0);
        set.insert(-1);
        set.remove(0);
        set.getRandom();
    }

    public static String ip(String ip) {
        int dot = 0;
        for (char c : ip.toCharArray()) {
            if (c == '.') dot++;
        }
        if (dot == 3) return "ip4";
        int colon = 0;
        for (char c : ip.toCharArray()) {
            if (c == ':') colon++;
        }
        if (colon == 7) return "ip6";
        return "Neither";

    }

    public static void print(String str) {
        System.out.println(str);
    }
}

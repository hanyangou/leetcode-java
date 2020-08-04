package com.po;

import com.po.leetcode.ListNode;
import com.po.leetcode.DataStructureUtils;
import com.po.quiz.linkedlist.Q445;

import static com.po.leetcode.DataStructureUtils.printlist;

public class Main {

    public static void main(String[] args) {
        Q445 q = new Q445();
        ListNode n = DataStructureUtils.getListNode(1, 2, 3, 4);
        printlist(n);
        printlist(q.reverse(n));
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

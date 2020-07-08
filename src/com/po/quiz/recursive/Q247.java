package com.po.quiz.recursive;

import java.util.ArrayList;
import java.util.List;

public class Q247 {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if(n == 1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        if(n == 2){
            res.add("11");
            res.add("88");
            res.add("96");
            res.add("69");
            return res;
        }

        return get(n, n);
    }

    public List<String> get(int n, int k){
        List<String> res = new ArrayList<>();
        if(n == 1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        if(n == 2){
            res.add("00");
            res.add("11");
            res.add("88");
            res.add("96");
            res.add("69");
            return res;
        }
        char[][] pairs = {{'0','0'},{'1','1'}, {'8','8'},{'9','6'}, {'6','9'}};
        List<String> list = get(n - 2, k);
        if(n == k){
            for(int i = 1; i < pairs.length; i++){
                for(String s : list){
                        res.add(pairs[i][0] + s + pairs[i][1]);
                    }
                }
        } else {
            for(int i = 0; i < pairs.length; i++){
                for(String s : list){
                    res.add(pairs[i][0] + s + pairs[i][1]);
                }
            }
        }
        return res;
    }
}

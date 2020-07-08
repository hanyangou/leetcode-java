package com.po.quiz.xor;

import java.util.ArrayList;
import java.util.List;

/***
 * constraint: 1. only one digit change 2. do not include duplicate
 *
 * challenge: how to design validation method
 * bit ops: 1 -> 0, 0 -> 1 . cur XOR 1
 * 0 ^ 0 = 0 0^1 = 1 1^0= 1 1^1 = 0
 * method to convert string of binary to int
 */
public class Q89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        //corner case: n = 0
        if(n == 0){
            res.add(0);
            return res;
        }
        StringBuilder sb = new StringBuilder();
        int counter = n;
        while (counter > 0){
            sb.append("0");
            counter--;
        }
        List<String> tmp = new ArrayList<>();
        backtrack(tmp, sb.toString().toCharArray(), 0, n);
        for(String s : tmp){
            res.add(convert(s));
        }
        return res;

    }

    public void backtrack(List<String> gc, char[] str, int idx, int n){
        //termination
        if(idx == n){
            gc.add(String.valueOf(str));
            return;
        }
        // XOR itself = keep the same. XOR another = flip it
        for(int i = 0; i <= 1; i++){
            //xor idx position
            char c = str[idx];
            int d = c == '0' ? 0 : 1;
            d ^= i;
            str[idx] = d == 0 ? '0' : '1';
            //backtrack
            backtrack(gc, str, idx + 1, n);
        }
        return;
    }

    public int convert(String str){
        StringBuilder sb = new StringBuilder(str).reverse();
        String reverse = sb.toString();
        int total = 0;
        for(int i = 0; i < reverse.length(); i++){
            if(reverse.charAt(i) == '1'){
                total += Math.pow(2.0, i);
            }
        }
        return total;
    }
}
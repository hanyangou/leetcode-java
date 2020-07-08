package com.po.quiz.math;

public class Q67 {
    public String addBinary(String a, String b) {
        //corner case???
        int[] carry = new int[Math.max(a.length(), b.length()) + 1];
        int idx = 0;
        while (idx < Math.min(a.length(), b.length())) {
            int first = a.charAt(a.length() - idx - 1) - '0';
            int second = b.charAt(b.length() - idx - 1) - '0';
            carry[idx + 1] = (first & second) | (first & carry[idx]) | (second & carry[idx]);
            carry[idx] = first ^ second ^ carry[idx];
            idx++;
        }
        if(idx < a.length()){
            for(int i = idx; i < a.length(); i++){
                int e = a.charAt(a.length() - i - 1) - '0';
                carry[i+1] = e & carry [i];
                carry[i] = e ^ carry[i];
            }
        }
        if(idx < b.length()){
            for(int i = idx; i < b.length(); i++){
                int e = b.charAt(b.length() - i - 1) - '0';
                carry[i+1] = e & carry[i];
                carry[i] = e ^ carry[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = carry.length - 1; i > 0; i--){
            if(sb.length() != 0 || carry[i] != 0){
                sb.append(carry[i]);
            }
        }
        sb.append(carry[0]);
        return sb.toString();
    }
}

/***
 BigInteger x = new BigInteger(a, 2);
 BigInteger y = new BigInteger(b, 2);
 BigInteger zero = new BigInteger("0", 2);
 BigInteger ans, carry;
 while (y.compareTo(zero) != 0){
 ans = x.xor(y);
 carry = x.and(y).shiftLeft(1);
 x = ans;
 y = carry;
 }
 return x.toString(2);
 ***/
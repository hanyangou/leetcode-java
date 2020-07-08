package com.po.quiz.math;

public class Q43 {
    public String multiply(String num1, String num2) {
        int[] carry = new int[num1.length() + num2.length()];

        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int i1 = num1.charAt(i) - '0';
                int i2 = num2.charAt(i) - '0';
                int mul = i1 * i2;
                int idx = (num2.length() - 1 - j) + (num1.length() - 1 - i);
                carry[idx+1] += (mul + carry[idx]) / 10;
                carry[idx] = (mul + carry[idx]) % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = carry.length - 1; i > 0; i--){
            if(sb.length() != 0 || carry[i] != 0) sb.append(carry[i]);
        }
        sb.append(carry[0]);
        return sb.toString();
    }
}


/***
 int m = num1.length();
 int n = num2.length();
 int[] pos = new int[m+n];

 for(int i = m -1; i >= 0; i--){
 for(int j = n - 1; j >= 0; j--){
 int a = num1.charAt(i) - '0';
 int b = num2.charAt(j) - '0';
 int p1 = i + j;
 int p2 = i + j + 1;
 int sum = a * b + pos[p2];
 pos[p1] = sum / 10;
 pos[p2] = sum % 10;
 }
 }

 StringBuilder sb = new StringBuilder();
 for(int i : pos){
 if(!(sb.length() == 0 && i == 0)) sb.append(i);
 }
 return sb.reverse().toString();
 }
***/
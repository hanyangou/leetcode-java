package com.po.quiz.math;

public class Q415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        //iterate through both strings..... length of strings are different
        //use zero if ptr is already outside of string
        while(i >= 0 || j >= 0 || carry != 0){
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = a + b + carry;
            int digit = sum % 10;
            carry = sum / 10;
            sb.append(digit);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}

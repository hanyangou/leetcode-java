package com.po.quiz.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q227 {
    public int calculate(String s) {
        //corner case
        int operand = 0;
        char sign = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                operand = operand * 10 + (c - '0');
            }
            if(i == s.length() - 1 || ((c != ' ') && !Character.isDigit(c))) {
                if(sign == '+'){
                    stack.push(operand);
                } else if (sign == '-'){
                    stack.push(-operand);
                } else if(sign == '*'){
                    stack.push(stack.pop() * operand);
                } else{
                    stack.push(stack.pop() / operand);
                }
                sign = c;
                operand = 0;
            }
        }
        int res = 0;
        for(int i : stack)
            res += i;
        return res;
    }
}

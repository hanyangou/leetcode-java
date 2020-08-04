package com.po.quiz.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q772 {
    public int calculate(String s) {
        int operand = 0;
        char sign = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            if(Character.isDigit(c))
                operand = operand * 10 + (c - '0');
            if(!Character.isDigit(c) && c != ' '){
                if (c == '(') { //recursive way to evaluate what inside the parenthesis
                    int j = i+1; //starting point is the next char so we can exclude '(' and ')'
                    int cnt = 0;
                    while (i < s.length()) {
                        if (s.charAt(i) == '(')
                            cnt++;
                        if (s.charAt(i) == ')')
                            cnt--;
                        if(cnt == 0)
                            break;
                        i++;
                    }
                    operand = calculate(s.substring(j, i));
                    //after running here, i is pointing to ')'
                } else {
                    operate(stack, sign, operand);
                    operand = 0;
                    sign = c;
                }
            }
        }
        //push last operand to stack
        operate(stack, sign, operand);
        int res = 0;
        for(int i : stack)
            res += i;
        return res;
    }
    public void operate(Deque<Integer> stack, char sign, int operand){
        if(sign == '+'){
            stack.push(operand);
        } else if(sign == '-') {
            stack.push(-operand);
        } else if (sign == '*'){
            stack.push(stack.pop() * operand);
        } else if (sign == '/'){
            stack.push(stack.pop() / operand);
        }
    }
}
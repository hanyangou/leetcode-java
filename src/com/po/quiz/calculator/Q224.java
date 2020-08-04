package com.po.quiz.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

//calculator 1 : +, - and parenthesis
public class Q224 {
    public int calculate(String s) {
        return recursive(s);
    }

    public int recursive(String s){
            //corner case????
            int operand = 0;
            int sign = 1;
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i< s.length(); i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    operand = operand * 10 + (c - '0');
                }
                if ((i == s.length() - 1) || (c != ' ' && !Character.isDigit(c))){
                    stack.push(sign * operand);
                    if(c == '('){
                        int j = i + 1; //starting pos
                        int cnt = 1;
                        i = j;
                        while (i < s.length() && cnt > 0){
                            if(s.charAt(i) == '(')
                                cnt++;
                            if(s.charAt(i) == ')')
                                cnt--;
                            i++;
                        }
                        i--;
                        stack.push(sign * calculate(s.substring(j, i)));
                    } else if(c == '+'){
                        sign = 1;
                        operand = 0;
                    } else if(c == '-'){
                        sign = -1;
                        operand = 0;
                    }
                }
            }
            int res = 0;
            for(int i : stack)
                res += i;
            return res;
    }

    public int iterative(String s){
        Deque<Object> stack = new ArrayDeque<>();
        int n = 0;
        int operand = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == ' ') continue; //assuming there is no space between digit
            if(Character.isDigit(c)){
                operand += Math.pow(10, n) * (c - '0');
                n++;
            } else {
                if(n > 0){
                    stack.push(operand);
                    n = 0;
                    operand = 0;
                }
                if(c == '('){
                    int evaluated = evaluate(stack);
                    stack.pop(); //popping out ')'
                    stack.push(evaluated);
                } else {
                    stack.push(c);
                }
            }
        }
        if(n > 0)
            stack.push(operand);

        return evaluate(stack);

    }

    public int evaluate(Deque<Object> stack){
        int res = (int)(stack.pop());
        while (!stack.isEmpty() && (char)stack.peek() != ')'){
            char sign = (char)stack.pop();
            if(sign == '+')
                res += (int)stack.pop();
            else
                res -= (int)stack.pop();
        }
        return res;
    }
}

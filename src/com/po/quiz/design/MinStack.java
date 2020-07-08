package com.po.quiz.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    class Pair{
        int val;
        int min;
        public Pair(int val, int prevMin){
            this.val = val;
            min = Math.min(val, prevMin);
        }
    }
    Deque<Pair> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        Pair p;
        if(stack.isEmpty())
            p = new Pair(x, x);
        else
            p = new Pair(x, stack.peek().min);
        stack.push(p);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

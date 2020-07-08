package com.po.quiz.design;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> original;
    Stack<Integer> reverse;
    /** Initialize your data structure here. */
    public MyQueue() {
        original = new Stack<>();
        reverse = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        dumpToOriginal();
        original.add(x);
        dumpToReverse();
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return reverse.pop();
    }

    /** Get the front element. */
    public int peek() {
        return reverse.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return reverse.isEmpty();
    }

    public void dumpToOriginal(){
        while (!reverse.isEmpty()) original.push(reverse.pop());
    }

    public void dumpToReverse(){
        while (!original.isEmpty()) reverse.push(original.pop());
    }
}

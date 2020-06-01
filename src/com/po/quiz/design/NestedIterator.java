package com.po.quiz.design;


import com.po.leetcode.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> integers;

    public NestedIterator(List<NestedInteger> nestedList) {
        integers = new Stack<>();
        for(int i = nestedList.size() - 1; i >= 0; i--){
            integers.add(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return integers.pop().getInteger();
        } else { //no element left in Iterator
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        makeTopInteger();
        return !integers.isEmpty();
    }

    private void makeTopInteger(){
        //check peek and unpack it if it's a list
        while(!integers.isEmpty() && !integers.peek().isInteger()){
            List<NestedInteger> list = integers.pop().getList();
            for(int i = list.size() - 1; i >= 0; i--){
                integers.add(list.get(i));
            }
        }
    }
}

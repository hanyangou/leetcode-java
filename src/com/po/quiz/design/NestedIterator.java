package com.po.quiz.design;


import com.po.leetcode.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    ArrayList<Integer> list;
    int idx;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        idx = 0;
        for(int i = 0; i < nestedList.size(); i++){
            NestedInteger ni = nestedList.get(i);
            if(ni.isInteger())
                list.add(ni.getInteger());
            else
                flatten(ni.getList());
        }
    }

    public void flatten(List<NestedInteger> nestedList){
        for(int i = 0; i < nestedList.size(); i++){
            NestedInteger ni = nestedList.get(i);
            if(ni.isInteger())
                list.add(ni.getInteger());
            else
                flatten(ni.getList());
        }
    }

    @Override
    public Integer next() {
        Integer ans = list.get(idx);
        idx++;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return idx < list.size();
    }

}

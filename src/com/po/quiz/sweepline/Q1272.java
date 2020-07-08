package com.po.quiz.sweepline;

import java.util.ArrayList;
import java.util.List;

public class Q1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        int removeStart = toBeRemoved[0];
        int removeEnd = toBeRemoved[1];
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            if(start >= removeEnd || end <= removeStart) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(start);
                tmp.add(end);
                res.add(tmp);
            } else if (start < removeStart && end > removeEnd){
                List<Integer> tmp1 = new ArrayList<>();
                tmp1.add(start);
                tmp1.add(removeStart);
                res.add(tmp1);
                List<Integer> tmp2 = new ArrayList<>();
                tmp2.add(removeEnd);
                tmp2.add(end);
                res.add(tmp2);
            } else if (start < removeStart && end <= removeEnd){
                List<Integer> tmp1 = new ArrayList<>();
                tmp1.add(start);
                tmp1.add(removeStart);
                res.add(tmp1);
            } else if (start >= removeStart && end >= removeEnd){
                List<Integer> tmp1 = new ArrayList<>();
                tmp1.add(removeEnd);
                tmp1.add(end);
                res.add(tmp1);
            }
        }
        return res;
    }
}

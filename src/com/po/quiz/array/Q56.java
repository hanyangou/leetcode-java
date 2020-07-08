package com.po.quiz.array;

import java.util.Arrays;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a1, a2) -> {
            return a1[0] - a2[0];
        });
        int write = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] i1 = intervals[write];
            int[] i2 = intervals[i];
            if(i1[1] >= i2[0]){
                if(i1[1] < i2[1]){
                    i1[1] = i2[1];
                }
            } else {
                write++;
                if(write != i){
                    intervals[write][0] = intervals[i][0];
                    intervals[write][1] = intervals[i][1];
                }
            }
        }
        int[][] ans = new int[write + 1][2];
        for(int i = 0; i <= write; i++){
            ans[i][0] = intervals[i][0];
            ans[i][1] = intervals[i][1];
        }
        return ans;
    }
}

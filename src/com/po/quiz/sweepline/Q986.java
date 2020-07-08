package com.po.quiz.sweepline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> points = new ArrayList<>();
        int START = 0, END = 1;
        for(int[] a : A){
            points.add(new int[]{a[0], START});
            points.add(new int[]{a[1], END});
        }
        for(int[] b : B){
            points.add(new int[]{b[0], START});
            points.add(new int[]{b[1], END});
        }
        Collections.sort(points, (p1, p2) ->{
            if(p1[0] != p2[0])
                return Integer.compare(p1[0], p2[0]);
            else
                return Integer.compare(p1[1], p2[1]);
        });
        int intervals = 0;
        int start = 0;
        int end = 0;
        List<int[]> overlapped = new ArrayList<>();
        for(int[] p : points){
            int x = p[0];
            int type = p[1];
            if(type == START){
                intervals++;
                if(intervals == 2){
                    start = x;
                }
            } else {
                if(intervals == 2){
                    overlapped.add(new int[]{start, x});
                }
                intervals--;
            }
        }
        int[][] ans = new int[overlapped.size()][];
        for(int i = 0; i < overlapped.size(); i++){
            ans[i] = overlapped.get(i);
        }
        return ans;
    }
}

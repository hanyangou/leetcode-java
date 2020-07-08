package com.po.quiz.sweepline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<int[]> availables = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        //sweep line
        //add start point
        //meet two start points then start collecting.
        //meet end point, remove it from list
        int START = 0, END = 1;
        List<int[]> points = new ArrayList<>();
        for(int[] p : slots1){
            points.add(new int[]{p[0], START});
            points.add(new int[]{p[1], END});
        }
        for(int[] p : slots2){
            points.add(new int[]{p[0], START});
            points.add(new int[]{p[1], END});
        }
        Collections.sort(points, (p1,p2) -> Integer.compare(p1[0], p2[0]));
        int intervals = 0;
        int start = 0;
        for(int[] p: points){
            int x = p[0];
            int type = p[1];
            if(intervals == 2){
                availables.add(new int[]{start, x});
            }

            if(type == START){
                intervals++;
                if(intervals == 2)
                    start = x;
            } else {
                intervals--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int[] a: availables){
            if(a[1] - a[0] >= duration){
                ans.add(a[0]);
                ans.add(a[0] + duration);
                break;
            }
        }
        return ans;
    }
}

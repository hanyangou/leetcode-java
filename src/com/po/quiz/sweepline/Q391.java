package com.po.quiz.sweepline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q391 {
    public boolean isRectangleCover(int[][] rectangles) {
        //edge case
        int START = 0, END = 1;
        List<int[]> points = new ArrayList<>();
        for(int[] r: rectangles){
            points.add(new int[]{r[1], START, r[0], r[2]});
            points.add(new int[]{r[3], END, r[0], r[2]});
        }
        Collections.sort(points, (p1, p2) -> {
            if(p1[0] != p2[0])
                return Integer.compare(p1[0], p2[0]);
            else {
                if(p1[2] != p2[2])
                    return Integer.compare(p1[2], p2[2]);
                else
                    return Integer.compare(p1[3], p2[3]);
            }
        });
        int curY = points.get(0)[0];
        Integer start = points.get(0)[2];
        Integer end = null;
        List<int[]> actives = new ArrayList<>();
        for(int[] p : points){
            int y = p[0];
            if(y != curY) {
                Integer prevEnd = null;
                Collections.sort(actives, (a1, a2) -> {
                    if(a1[0] != a2[0])
                        return Integer.compare(a1[0], a2[0]);
                    else
                        return Integer.compare(a1[1], a2[1]);
                });
                for(int i = 0 ; i < actives.size(); i ++){
                    int[] x = actives.get(i);
                    if(i > 0 && !prevEnd.equals(x[0])){
                        return false;
                    }
                    prevEnd = x[1];
                    if(i == 0 && !start.equals(x[0])) {
                        return false;
                    }
                }
                if(end == null)
                    end = prevEnd;
                else {
                    if(!prevEnd.equals(end))
                        return false;
                }
                curY = y;
            }
            if(p[1] == START){
                actives.add(new int[]{p[2], p[3]});
            } else {
                for(int i = 0; i < actives.size(); i++){
                    if(actives.get(i)[0] == p[2] && actives.get(i)[1] == p[3]){
                        actives.remove(i);
                        break;
                    }
                }
            }
        }
        return true;
    }
}

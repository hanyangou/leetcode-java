package com.po.quiz.sweepline;

import java.util.*;

public class Q850 {
    public int rectangleArea(int[][] rectangles) {
        int START = 0, END = 1;
        int[][] events = new int[rectangles.length * 2][4];
        int idx = 0;
        for(int [] r : rectangles){
            events[idx++] = new int[]{r[1], START, r[0], r[2]};
            events[idx++] = new int[]{r[3], END, r[0], r[2]};
        }
        Arrays.sort(events, (e1, e2) ->{ //sort based on y, x1, x2
            if(e1[0] != e2[0])
                return Integer.compare(e1[0], e2[0]);
            else {
                if(e1[2] != e2[2])
                    return Integer.compare(e1[2],  e2[2]);
                else {
                    return Integer.compare(e1[3], e2[3]);
                }
            }
        });
        List<int[]> points = new ArrayList<>();
        int prevY = events[0][0]; //starting Y
        long area = 0;
        for(int[] e : events){
            int curY = e[0];
            if(curY != prevY){ //calculate area
                //sort active first
                Collections.sort(points, (p1, p2) ->{
                    if(p1[0] != p2[0])
                        return Integer.compare(p1[0], p2[0]);
                    else
                        return Integer.compare(p1[1], p2[1]);
                });
                int totalX = 0;
                int curX = 0;
                for(int[] p : points){
                    curX = Math.max(curX, p[0]);
                    totalX += Math.max(0, p[1] - curX);
                    curX = Math.max(curX, p[1]);
                }
                area += totalX * (curY - prevY);
            }
            if(e[1] == START) {
                points.add(new int[]{e[2], e[3]});
            } else {
                for (int i = 0; i < points.size(); i++){
                    if(points.get(i)[0] == e[2] && points.get(i)[1] == e[3]){
                        points.remove(i);
                        break;
                    }
                }
            }
            prevY = curY;
        }
        double mod = Math.pow(10, 9) + 7;

        return (int)(area % mod);
    }
}

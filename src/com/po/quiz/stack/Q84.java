package com.po.quiz.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int maxArea = 0;
        Deque<int[]> stack = new ArrayDeque<>(); //[height, idx]
        stack.push(new int[]{0, -1});
        for(int i = 0; i < heights.length; i++){
            int h = heights[i];
            //same heights ?
            while (h < stack.peek()[0]){
                int[] top = stack.pop();
                int height = top[0];
                int left = stack.peek()[1] + 1;
                int right = i;
                int area = height * (right - left);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(new int[]{h, i});
        }
        int right = heights.length;
        while (stack.size() > 1){ //the last element does not count
            int[] top = stack.pop();
            int height = top[0];
            int left = stack.peek()[1] + 1;
            int area = height * (right - left);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

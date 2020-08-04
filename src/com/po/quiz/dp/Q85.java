package com.po.quiz.dp;

import java.util.Arrays;

public class Q85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int maxArea = 0;
        Arrays.fill(right, n - 1);
        for(int i = 0; i < m; i++){
            int curLeft = 0;
            int curRight = n - 1;
            //update height
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            //update left
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }

            }
            //update right
            for(int j = n - 1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n - 1;
                    curRight = j - 1;
                }
            }
            //update area
            for(int j = 0; j < n; j++){
                int area = (right[j] - left[j] + 1) * height[j];
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

}

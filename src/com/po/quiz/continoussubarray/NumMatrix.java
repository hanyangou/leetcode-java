package com.po.quiz.continoussubarray;

public class NumMatrix {
    int[][] matrix;
    int[][] sums;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if(matrix == null || matrix.length == 0) return;
        sums = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < sums.length; i++){
            int sum = 0;
            for(int j = 0; j < matrix[0].length; j++){
                sum += matrix[i][j];
                sums[i][j] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++){
            if(col1 == 0){
                sum += sums[i][col2];
            } else {
                sum += sums[i][col2] - sums[i][col1 - 1];
            }
        }
        return sum;
    }
}

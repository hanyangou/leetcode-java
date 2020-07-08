package com.po.quiz.binarysearch;

public class Q240 {
    public boolean searchMatrix(int[][] matrix, int target) {
       if(matrix == null || matrix.length == 0) return false;
       int br = matrix.length;
       int bc = matrix[0].length;

       int row = 0, col = bc - 1;
       while (row < br && col >= 0){
           if(matrix[row][col] == target) return true;
           else if(matrix[row][col] < target) row++;
           else {
               col--;
           }
       }
       return false;
    }
}

package com.po.quiz.dfs;

public class Q695 {
    public int maxAreaOfIsland(int[][] grid) {
        //corner case
        if(grid == null) return 0;

        int max = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = getArea(grid, i, j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private int getArea(int[][] grid, int row, int col){
        if(row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        int area = 1;
        area += getArea(grid, row - 1, col);
        area += getArea(grid, row + 1, col);
        area += getArea(grid, row, col - 1);
        area += getArea(grid, row, col + 1);
        return area;
    }
}

package com.po.quiz.bfs;

import com.po.leetcode.Triple;

import java.util.LinkedList;
import java.util.Queue;

public class Q994 {
    int max = 0;
    Queue<Triple> queue;
    public int orangesRotting(int[][] grid) {
        queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Triple(i - 1, j, 0));
                    queue.add(new Triple(i + 1, j, 0));
                    queue.add(new Triple(i, j - 1, 0));
                    queue.add(new Triple(i, j + 1, 0));
                }
            }
        }
        while(!queue.isEmpty()){
            Triple t = queue.poll();
            rotten(grid, t.L, t.M, t.R);
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return max;
    }

    public void rotten(int[][] grid, int row, int col, int current){
        if(row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length -1 || grid[row][col] != 1){
            return;
        }
        current++;
        max = Math.max(max, current);
        grid[row][col] = 2;
        queue.add(new Triple(row - 1, col, current));
        queue.add(new Triple(row + 1, col, current));
        queue.add(new Triple(row, col - 1, current));
        queue.add(new Triple(row, col + 1, current));
    }
}
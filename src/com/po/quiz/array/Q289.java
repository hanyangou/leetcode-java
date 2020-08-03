package com.po.quiz.array;

public class Q289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] direction = new int[][]{{-1,-1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1,1}};
        int LIVE = -1, DEAD = 2;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int lives = 0;
                for(int[] d: direction){
                    int nextX = i + d[0];
                    int nextY = j + d[1];
                    if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;
                    if(board[nextX][nextY] > 0) lives++;
                }
                if(board[i][j] == 1){
                    if(lives < 2 || lives > 3) board[i][j] = DEAD;
                } else {
                    if(lives == 3) board[i][j] = LIVE;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (board[i][j] == LIVE) board[i][j] = 1;
                else if (board[i][j] == DEAD) board[i][j] = 0;
            }
        }
    }
}

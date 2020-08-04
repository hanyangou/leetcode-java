package com.po.quiz.design;

/***
 * diag? x = y AND x + y = n -1
 */

public class TicTacToe {
    int[][] board;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int r = 0;
        int c = 0;
        board[row][col] = player;
        int win = 0;
        for(int i = 0; i < n; i++){
            r = board[i][0];
            c = board[0][i];
            for(int j = 0; j < n; j++){
                if(board[i][j] != r)
                    r = 0;
                if(board[j][i] != c)
                    c = 0;
            }
            if(r != 0){
                win = r;
                break;
            } else if( c != 0){
                win = c;
                break;
            }
        }
        if(win == 0){
            int d1 = board[0][0], d2 = board[0][n-1];
            for(int i = 0; i < n; i++){
                if(board[i][i] != d1)
                    d1 = 0;
                if(board[i][n - 1 - i] != d2)
                    d2 = 0;
            }
            if(d1 != 0)
                win = d1;
            else if(d2 != 0)
                win = d2;
        }
        return win;
    }
}

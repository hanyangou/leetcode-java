package com.po.quiz.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Q529 {
    int br;
    int bc;
    int[][] dirs = new int[][]{{-1, -1}, {-1, 0,}, {-1 , 1}, {0, -1}, {0,0}, {0, 1}, {1, -1}, {1, 0}, {1,1}};
    boolean[][] visited;
    public char[][] updateBoard(char[][] board, int[] click) {
        //corner case
        if(board == null || board.length == 0) return board;
        if(click == null || click.length == 0) return board;

        br = board.length;
        bc = board[0].length;
        visited = new boolean[br][bc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            bfs(board, pos[0], pos[1], queue);
        }

        return board;
    }

    private void bfs(char[][] board, int row, int col, Queue<int[]> queue){
        //out of boundary, just return
        if(row < 0 || row > br - 1 || col < 0 || col > bc - 1 || visited[row][col] == true) return;
        visited[row][col] = true;
        //click on mine, mark as X and return
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
            return;
        }
        //click on empty cell - check if neighbor cell has mine first
        //yes -- return # of mine
        //no -- reveal cells as much as possible
        int mines = 0;
        for(int[] dir : dirs){
            int nextX = row + dir[0];
            int nextY = col + dir[1];
            if(isInBoundry(nextX, nextY) && board[nextX][nextY] == 'M'){
                mines++;
            }
        }
        //there are mines in neighbor cell(s) -> put number on cell
        if(mines > 0){
            board[row][col] = (char) (mines + '0');
            return;
        }
        //empty cell -> change to 'B' and reveal all neighbor cells as much as possible
        board[row][col] = 'B';
        for(int[] dir : dirs) queue.offer(new int[]{row + dir[0], col + dir[1]});
        return;
    }

    private boolean isInBoundry(int row, int col){
        return !(row < 0 || row > br - 1 || col < 0 || col > bc - 1);
    }
}

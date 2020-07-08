package com.po.quiz.backtrack;

/***
 * constraint: the visited word cannot be used twice. the next word has to be adjacent cell - 4 directions
 * termination condition: when all characters are found
 *
 */
public class Q79 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1,0}};
    public boolean exist(char[][] board, String word) {
        //corner condition

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backtrack(board, visited, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, boolean[][] visited, int row, int col, String word, int idx){
        //termination
        if(idx == word.length()) return true;
        //backtracking steps
        //check constraint
        //place
        //backtrack
        //remove
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && visited[row][col] == false && board[row][col] == word.charAt(idx)){
            visited[row][col] = true;
            for(int[] d : directions){
                if(backtrack(board, visited, row + d[0], col + d[1], word, idx + 1)) return true;
            }
            visited[row][col] = false;
        }
        return false;
    }
}

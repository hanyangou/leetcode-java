package com.po.quiz.graph;

public class Q200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        if(grid == null || grid.length == 0) return ans;

        int rb = grid.length;
        int cb = grid[0].length;
        for(int i = 0 ; i < rb; i++){
            for(int j = 0; j < cb; j++){
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int row, int col){
        //terminate case
        int rb = grid.length;
        int cb = grid[0].length;
        if(row < 0 || row > rb - 1 || col < 0 || col > cb - 1 || grid[row][col] == '0') return;
        //flip to visited
        grid[row][col] = '0';
        //dfs next level
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}

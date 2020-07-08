package com.po.quiz.bfs;

import java.util.*;

public class Q417 {
    int br;
    int bc;
    int[][] dir = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return ans;

        br = matrix.length;
        bc = matrix[0].length;

        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();
        boolean[][] pVisited = new boolean[br][bc];
        boolean[][] aVisited = new boolean[br][bc];
        //adding cells next to ocean to their own queues
        for(int i = 0; i < bc; i++){
            pacificQ.add(new int[]{0, i});
            pVisited[0][i] = true;
        }
        for(int i = 0; i < br; i++){
            pacificQ.add(new int[]{i, 0});
            pVisited[i][0] = true;
        }
        for(int i = 0; i < bc; i++){
            atlanticQ.add(new int[]{br - 1, i});
            aVisited[br - 1][i] = true;
        }
        for(int i = 0; i < br; i++){
            atlanticQ.add(new int[]{i, bc - 1});
            aVisited[i][bc - 1] = true;
        }
        while(!pacificQ.isEmpty()){
            int[] pos = pacificQ.poll();
            bfs(matrix, pos[0], pos[1], pacificQ, pVisited);
        }
        while(!atlanticQ.isEmpty()){
            int[] pos = atlanticQ.poll();
            bfs(matrix, pos[0], pos[1], atlanticQ, aVisited);
        }

        for(int i = 0; i < br; i++){
            for(int j = 0; j < bc; j++){
                if(pVisited[i][j] == true && aVisited[i][j] == true){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(i);
                    sub.add(j);
                    ans.add(sub);
                }
            }
        }
        return ans;
    }

    private void bfs(int[][] matrix, int row, int col, Queue<int[]> queue, boolean[][] visited){
        for(int[] d : dir){
            int nextR = row + d[0];
            int nextC = col + d[1];
            if(nextR < 0 || nextR > br - 1 || nextC < 0 || nextC > bc - 1 || visited[nextR][nextC] == true
                    || matrix[row][col] > matrix[nextR][nextC]) continue;
            visited[nextR][nextC] = true;
            queue.offer(new int[]{row + d[0], col + d[1]});
        }
        return;
    }
}

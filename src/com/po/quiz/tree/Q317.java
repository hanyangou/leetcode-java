package com.po.quiz.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q317 {
    int br, bc;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int buildings;
    public int shortestDistance(int[][] grid) {
        //corner case
        br = grid.length;
        bc = grid[0].length;
        buildings = 0;
        int[][] distances = new int[br][bc];
        int[][] reaches = new int[br][bc];
        for (int i = 0; i < br; i++) { //O(m*n)
            for (int j = 0; j < bc; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    for(int[] dir: directions)
                        queue.add(new int[]{i + dir[0], j + dir[1], 0});
                    boolean[][] visited = new boolean[br][bc];
                    while (!queue.isEmpty()){ //O(m*n)
                        int[] loc = queue.poll();
                        int row = loc[0];
                        int col = loc[1];
                        int dis = loc[2];
                        explore(grid, distances, reaches, visited, queue, row, col, dis);
                    }
                    buildings++;
                }

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < br; i++) {
            for (int j = 0; j < bc; j++) {
                if (grid[i][j] == 0 && reaches[i][j] == buildings)
                    min = Math.min(min, distances[i][j]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void explore(int[][] grid, int[][] distances, int[][] reaches, boolean[][] visited, Queue<int[]> queue, int row, int col, int distance) {
        //early termination for bfs if this block cannot be reached by all previous buildings
        if (row < 0 || row >= br || col < 0 || col >= bc || visited[row][col] || grid[row][col] != 0 || reaches[row][col] < buildings) return;
        distance++;
        distances[row][col] += distance;
        reaches[row][col]++;
        visited[row][col] = true;
        for (int[] dir : directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            queue.add(new int[]{nRow, nCol, distance});
        }
    }
}

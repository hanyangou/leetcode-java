package com.po.quiz.array;

import java.util.*;

public class Q773 {
    int m = 2;
    int n = 3;

    public int slidingPuzzle(int[][] board) {
        String end = Arrays.deepToString(new int[][]{{1, 2, 3}, {4, 5, 0}});
        if (Arrays.deepToString(board).equals(end)) return 0;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Set<String> seen = new HashSet<>();
        Queue<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0)
                    queue.add(new Pair(board, 0, new int[]{i, j}));
            }
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            String hash = Arrays.deepToString(p.board);
            if (seen.contains(hash)) continue;
            seen.add(hash);
            int move = p.move + 1;
            for (int[] d : directions) {
                int[] zero = p.zero;
                int nextX = zero[0] + d[0];
                int nextY = zero[1] + d[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    int[][] newBoard = getNewBoard(p.board, zero[0], zero[1], nextX, nextY);
                    if (Arrays.deepToString(newBoard).equals(end))
                        return move;
                    queue.add(new Pair(newBoard, move, new int[]{nextX, nextY}));
                }
            }
        }
        return -1;
    }

    public int[][] getNewBoard(int[][] board, int i, int j, int x, int y) {
        int[][] newB = new int[m][n];
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (k == x && l == y)
                    newB[k][l] = board[i][j];
                else if (k == i && l == j)
                    newB[k][l] = board[x][y];
                else
                    newB[k][l] = board[k][l];
            }
        }
        return newB;
    }

    class Pair {
        int[][] board;
        int move;
        int[] zero;

        public Pair(int[][] board, int move, int[] zero) {
            this.board = board;
            this.move = move;
            this.zero = zero;
        }
    }
}

package com.po.quiz.backtrack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q37 {
    char[][] board;
    int br;
    int bc;
    boolean found;
    Map<Integer, Set<Character>> rows;
    Map<Integer, Set<Character>> cols;
    Map<Integer, Set<Character>> boxes;
    public void solveSudoku(char[][] board) {
        this.board = board;
        br = 9;
        bc = 9;
        rows = new HashMap<>();
        cols = new HashMap<>();
        boxes = new HashMap<>();
        found = false;
        for(int i = 0; i <= 8; i++){
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            boxes.put(i, new HashSet<>());
        }
        for(int i = 0; i < br; i++){
            for(int j = 0; j < bc; j++){
                if(board[i][j] != '.'){
                    char c = (char)(board[i][j]);
                    track(i, j, c);
                }
            }
        }
        backtrack(0,0);
        return;
    }

    public void backtrack(int i, int j){
        if(i == br){ //finish sudoku
            found = true;
            return;
        }

        if(board[i][j] != '.'){
            int[] next = getNext(i, j);
            backtrack(next[0], next[1]);
        } else {
            for(int k = 1; k <= 9; k++){
                if(isValid(i, j, k)){
                    char c = (char)(k + '0');
                    board[i][j] = c;
                    track(i, j, c);
                    int[] next = getNext(i, j);
                    backtrack(next[0], next[1]);
                    if(found)
                        return;
                    else {
                        board[i][j] = '.';
                        remove(i, j, c);
                    }
                }
            }
        }
    }

    public void track(int i, int j, char c){
        Set<Character> row = rows.get(i);
        row.add(c);
        rows.put(i, row);
        Set<Character> col = cols.get(j);
        col.add(c);
        cols.put(j, col);
        Set<Character> box = boxes.get(getBox(i, j));
        box.add(c);
        boxes.put(getBox(i, j), box);
    }

    public void remove(int i, int j, char c){
        Set<Character> row = rows.get(i);
        row.remove(c);
        rows.put(i, row);
        Set<Character> col = cols.get(j);
        col.remove(c);
        cols.put(j, col);
        Set<Character> box = boxes.get(getBox(i, j));
        box.remove(c);
        boxes.put(getBox(i, j), box);
    }

    public boolean isValid(int i, int j, int num){
        char c = (char)(num + '0');
        if(cols.get(j).contains(c))
            return false;
        if(rows.get(i).contains(c))
            return false;
        //check box
        if(boxes.get(getBox(i, j)).contains(c))
            return false;
        return true;
    }

    public int getBox(int i, int j){
        return (i / 3) * 3 + ( j / 3);
    }

    public int[] getNext(int i, int j){
        if(j == 8)
            return new int[]{i+1, 0};
        else
            return new int[]{i, j+1};
    }
}

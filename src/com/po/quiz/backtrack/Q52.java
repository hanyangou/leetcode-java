package com.po.quiz.backtrack;

import java.util.ArrayList;
import java.util.List;

/***
 * thoughts: first, design the method to handle the constrain (queen is under attack)
 * second step is to run build backtracking pattern if constrain is fulfilled
 * 1. check if reaching termination condition -- # of queen == N
 * 2. place queen, adding it to tracking board
 * 3. run backtracking with advancing row
 * 4. remove placed queen.
 *
 * special knowledge: dale diagonal and hill diagonal
 * dale: row - col = const
 * hill: row + col = const
 *
 */
public class Q52 {
    public int totalNQueens(int n) {
        List<Position> queens = new ArrayList<>();
        return backtrack(0, n, queens, 0);
    }

    public int backtrack(int count, int n, List<Position> queens, int row){
        /***
         * return count as result under current queen placement
         */
        if(row == n)
            return count+1;

        for(int col = 0; col < n; col++){
            //fulfill constrain
            if(!isUnderAttack(queens, row, col)){
                //place new queen
                queens.add(row, new Position(row, col));
                //backtracking
                count = backtrack(count, n, queens, row + 1);
                //remove placed queen
                queens.remove(row);
            }
        }
        return count;
    }

    public boolean isUnderAttack(List<Position> queens, int row, int col){
        /***
         *  a queen is under attack when the row is taken or
         *  hill = row + col is taken or
         *  dale = row - col is taken
          */
        for(int q = 0; q < queens.size(); q++){
            Position queen = queens.get(q);
            if(queen.col == col || (queen.row + queen.col) == (row + col) || (queen.row - queen.col) == (row - col)){
                return true;
            }
        }

        return false;
    }

    class Position{
        public int row;
        public int col;
        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}

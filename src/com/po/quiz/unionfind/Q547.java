package com.po.quiz.unionfind;

public class Q547 {

    /***
     * Thought: running union-find to form the friendship circle
     * will it be a problem if two students have been union before????
     * how to determine the number for the circle???
     * only running half of the matrix
     *
     * Corner case: when M is null or length of M is 0, return 0
     *
     */
    public int findCircleNum(int[][] M) {
        //corner case
        if(M == null || M.length == 0) return 0;
        int[] parent = new int[M.length];
        //initialize parent to -1 indicating there is no parent for each of node
        for(int i = 0; i < parent.length; i++)
            parent[i] = -1;
        //iterating through all students, union two students if they are direct friends
        for(int i = 0; i < M.length; i++){
            for(int j = i+1; j < M[0].length; j++){
                if(M[i][j] == 1){ //
                    union(parent, i, j);
                }
            }
        }
        //determine the number for cycles
        int ans = 0;
        for(int p : parent){
            if(p == -1)
                ans++;
        }
        return ans;
    }

    private void union(int[] parent, int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        if(xset != yset)
            parent[xset] = yset;
    }

    private int find(int[] parent, int x){
        int p = parent[x];
        if(p == -1)
            return x;
        return find(parent, p);
    }
}

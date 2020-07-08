package com.po.quiz.bst;

public class Q96 {
    public int numTrees(int n) {
        int[] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        //i = 1 - n
        for(int i  = 2; i <= n; i++){ //nums of nodes
            for(int j = 1; j <= i; j++){ //center position
                g[i] += g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }
}
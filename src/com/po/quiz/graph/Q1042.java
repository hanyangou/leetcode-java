package com.po.quiz.graph;

import java.util.ArrayList;

/***
 *  Challenge: how do i know which color is available?
 *
 */
public class Q1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        //corner case: N = 0 and 1;
        //N : 1 - N
        int[] res = new int[N];
        if (N == 0) return res;
        if (N == 1) {
            res[0] = 1;
            return res;
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < paths.length; i++) {
            int[] path = paths[i];
            int n1 = path[0] - 1; //subtract 1 bc N starts from 1
            int n2 = path[1] - 1;
            ArrayList<Integer> l1 = graph.get(n1);
            ArrayList<Integer> l2 = graph.get(n2);
            l1.add(n2);
            l2.add(n1);
        }

        int[] colors = new int[N]; //color range is 1 - 4, we use 0 indicating its uncolor.
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];

            ArrayList<Integer> neighbors = graph.get(i);
            for (Integer n : neighbors) {
                used[colors[n]] = true;
            }
            for (int j = 1; j < 5; j++) {
                if (!used[j]) {
                    colors[i] = j;
                    break;
                }
            }
        }
        return colors;
    }
}

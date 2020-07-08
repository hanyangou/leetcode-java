package com.po.quiz.array;

import java.util.Stack;

public class Q739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < T.length; i++){
            int[] pair = new int[]{T[i], i};
            while (!stack.isEmpty() && pair[0] > stack.peek()[0]){
                int[] e = stack.pop();
                res[e[1]] = pair[1] - e[1];
            }
            stack.push(pair);
        }
        return res;
    }
}

package com.po.quiz.array;

import java.util.Arrays;
import java.util.Stack;

/***
 * duplicate items in nums?????
 * and mod position by nums.length
 */
public class Q503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] doubles = new int[nums.length * 2];
        for(int i = 0; i < nums.length * 2; i++){
            doubles[i] = nums[i % nums.length];
        }
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for(int i = 0; i < doubles.length; i++){
            int[] pair = new int[]{doubles[i], i};
            while (!stack.isEmpty() && pair[0] > stack.peek()[0]){
                int[] e = stack.pop();
                res[e[1] % nums.length] = pair[0];
            }
            stack.push(pair);
        }
        return res;
    }
}

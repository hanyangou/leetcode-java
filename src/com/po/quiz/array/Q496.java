package com.po.quiz.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * using stack. if element is <= peek, push. otherwise it is next great element for all elements that are less than it. after iterating
 * nums2, the one remaining in the stack has no next greater one
 *
 * idx1 : [element in nums1, position in nums1]
 *
 */
public class Q496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //corner case: both are empty
        int[] res = new int[nums1.length];
        if(nums2 == null || nums2.length == 0) return res;

        Map<Integer, Integer> idx1 = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            idx1.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i++){
            int n = nums2[i];
            while (!stack.isEmpty() && n > stack.peek()){
                int top = stack.pop();
                if(idx1.containsKey(top)){
                    int idx = idx1.get(top);
                    res[idx] = n;
                }
            }
            stack.push(n);
        }
        while (!stack.isEmpty()){
            int n = stack.pop();
            if(idx1.containsKey(n))
                res[idx1.get(n)] = -1;
        }
        return res;
    }
}
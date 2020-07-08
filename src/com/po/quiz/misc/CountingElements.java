package com.po.quiz.misc;

import java.util.Arrays;

public class CountingElements {
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        int total = 1;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1] - 1) ans += total;
            if(arr[i] == arr[i+1]) total++;
            else total = 1;
        }
        return ans;
    }
}

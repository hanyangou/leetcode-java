package com.po.quiz.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //avoid duplication -- set? sorted list in set
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int e = nums[i];
            int lo = i + 1;
            int high = nums.length - 1;
            while (lo < high){
                if(nums[lo] == nums[lo+1]){
                    lo++;
                    continue;
                }
                if(nums[high] == nums[high - 1]){
                    high--;
                    continue;
                }
                int combine = nums[lo] + nums[high];
                if( combine == -e){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(e);
                    sub.add(nums[lo]);
                    sub.add(nums[high]);
                    res.add(sub);
                } else if (combine < -e){
                    lo++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}

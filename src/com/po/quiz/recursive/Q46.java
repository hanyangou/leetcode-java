package com.po.quiz.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q46 {
    Integer len;
    public List<List<Integer>> permute(int[] nums) {
        //corner case???
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        if(nums.length == 1){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[0]);
            res.add(tmp);
            return res;
        }
        len = nums.length;
        recursive(nums, res, new ArrayList<>(), new HashSet<>());
        return res;
    }
    public void recursive(int[] nums, List<List<Integer>> res, List<Integer> tmp, Set<Integer> set){
        if(tmp.size() == len){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < len; i++){
            if(set.contains(i)) continue;
            tmp.add(nums[i]);
            set.add(i);
            recursive(nums, res, tmp, set);
            tmp.remove(tmp.size() - 1);
            set.remove(i);
        }
    }
}

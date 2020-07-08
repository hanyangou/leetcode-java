package com.po.quiz.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q47 {
    Integer len;
    public List<List<Integer>> permuteUnique(int[] nums) {
        //corner case???
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        if(nums.length == 1){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[0]);
            ans.add(tmp);
            return ans;
        }
        len = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        recursive(nums, res, new ArrayList<>(), new HashSet<>());
        ans.addAll(res);
        return ans;
    }
    public void recursive(int[] nums, Set<List<Integer>> res, List<Integer> tmp, Set<Integer> set){
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

package com.po.quiz.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //corner case

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        find(nums, 4, res, new ArrayList<>(), target);
        return res;
    }

    public void find(int[] nums, int n, List<List<Integer>> res, List<Integer> tmp, int target){
        //corner case
        if(nums.length < n || n < 2) return;
        //2-sum case
        if(n == 2){
            int left = 0, right = nums.length - 1;
            while (left < right){
                int sum = nums[left] + nums[right];
                if( sum == target){
                    List<Integer> sub = new ArrayList<>(tmp);
                    sub.add(nums[left]);
                    sub.add(nums[right]);
                    if(!res.contains(sub))
                        res.add(sub);
                    left++;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return;
        } else { //n-sum
            if(nums[nums.length - 1] * n < target) return;
            for(int i = 0; i < nums.length; i++){
                int num = nums[i];
                if(num * n > target) return; //sum of rest of elements will greater than target
                tmp.add(num);
                find(Arrays.copyOfRange(nums,i + 1, nums.length), n - 1, res, tmp, target - num);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

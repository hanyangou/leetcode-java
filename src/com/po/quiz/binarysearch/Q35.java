package com.po.quiz.binarysearch;

public class Q35 {
    public int searchInsert(int[] nums, int target) {
        //return idx if target is found
        //otherwise when binary search ends, return that idx
        //corner case???
        int left = 0, right = nums.length - 1;
        while (left < right){
            int pivot = (left + right) / 2;
            if(nums[pivot] == target) return pivot;
            if(nums[pivot] > target) { //pivot > target, target is on left side
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        if(nums[left] >= target) return left;
        else return left + 1;
    }
}

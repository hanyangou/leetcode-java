package com.po.quiz.binarysearch;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int[] ans = new int[2];
        int left = findLeftEdge(nums, target);
        if(nums[left] != target){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        ans[0] = left;
        ans[1] = findRightEdge(nums, target, ans[0], nums.length - 1);
        return ans;
    }

    //rightmost is looking for pivot == target and pivot + 1 != target
    private int findRightEdge(int[] nums, int target, int left, int right){
        while (left < right){
            int pivot = left + (right - left) / 2;
            if(nums[pivot] == target){
                if(nums[pivot + 1] != target) return pivot;
                else left = pivot + 1;
            } else if(nums[pivot] > target){ //  l < t < p
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }

    private int findLeftEdge(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int pivot = left + (right - left) / 2;
            if(nums[pivot] == target){ //keeping looking left side with pivot inclided
                right = pivot;
            } else if(nums[pivot] > target) { //l < t < p
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }
}

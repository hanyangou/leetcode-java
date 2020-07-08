package com.po.quiz.array;

public class Q31 {
    public void nextPermutation(int[] nums) {
        //starting from the bottom, finding the index that a[i] < a[i+1]
        //if not found.... already biggest permutation. return the smallest one (reverse it)
        //swap it
        int idx = nums.length - 1;
        //find idx
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }
        //if not found, return smallest
        if(idx == nums.length - 1){
            reverse(nums, 0);
            return;
        }
        //looking for element on right of idx that just above it
        int minIdx = idx + 1;
        for(int i = idx + 2; i < nums.length; i++){
            if(nums[i] <= nums[idx]) break;
            minIdx = i;
        }
        swap(nums, idx, minIdx);
        reverse(nums, idx + 1);
    }

    public void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while (start <= end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/***        //biggest arrangement already. return sorted one

 int n = nums.length - 2;
 while (n >= 0){
 if(nums[n] < nums[n + 1]) break;
 n--;
 }
 if(n < 0 ) { //all elements are sorted in descending order, sort nums and return it
 Arrays.sort(nums);
 return;
 }
 int min = Integer.MAX_VALUE;
 int pivot = nums[n];
 int idx = n;
 for(int i = n + 1; i < nums.length; i++){
 if(nums[i] > pivot && nums[i] - pivot < min) {
 min = nums[i] - pivot;
 idx = i;
 }
 }
 swap(nums, n, idx);
 int[] sub = Arrays.copyOfRange(nums, n+1, nums.length);
 Arrays.sort(sub);
 for(int i = n + 1; i < nums.length; i ++){
 nums[i] = sub[i - (n+1)];
 }
 return;

 }

 public void swap(int[] nums, int i, int j){
 int tmp = nums[i];
 nums[i] = nums[j];
 nums[j] = tmp;
 }
***/
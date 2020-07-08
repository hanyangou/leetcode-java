package com.po.quiz.binarysearch;

public class Q153 {
    public int findMin(int[] nums) {
        //corner case
        if(nums.length == 1) return nums[0];
        return findPivot(nums, 0 , nums.length - 1);
    }

    public int findPivot(int[] nums, int left, int right){
        //return pivot idx that points to smallest element
        //1 2 3 4 5
        //4 5 1 2 3
        //3 4 5 1 2
        //5 1 2 3 4
        //2 1
        //3 1 2
        if(nums[left] < nums[right]) return nums[left];
        //no unique -> dont consider equal
        while (left <= right){ //left == right is a problem?
            if(left == right) return nums[left];
            int pivot = (left + right) / 2;
            if(nums[pivot] > nums[pivot + 1]) return pivot + 1; //is boundary a problem??
            if(nums[left] > nums[pivot]){
                right = pivot; //boundary????
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }
}

package com.po.quiz.binarysearch;

public class Q33 {
    int[] nums;
    public int search(int[] nums, int target) {
        this.nums = nums;
        int size = nums.length;
        if(nums == null || size == 0) return -1;

        if(size == 1) return nums[0] == target ? 0 : -1;
        int rotateIndex =  findRotateIndex(0, nums.length - 1);

        if(target == nums[rotateIndex]) return rotateIndex;
        if(rotateIndex == 0) return bs(0, size - 1, target);
        if(target < nums[0]) return bs(rotateIndex + 1, size - 1, target);
        else return bs(0, rotateIndex - 1, target);
    }

    private int bs(int left, int right, int target){
        if(left > right) return -1;
        if(left == right) return nums[left] == target ? left : -1;
        while (left <= right){
            if(left == right) return nums[left] == target ? left : -1;
            int pivot = (left + right) / 2;
            if(nums[pivot] == target) return pivot;
            if(nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }

    private int findRotateIndex(int left, int right){
        //if left <  right, thats right sequence
        //if not, split the array to half and perform the search again
        if(nums[left] <= nums[right]) return 0;
        while(left <= right){
            if(nums[left] < nums[right]) return left;
            int pivot = (left + right) / 2;
            if(nums[pivot] > nums[pivot + 1]) return pivot + 1;
            //if element at pivot position is greater than element at left, the smallest index locates in right half
            //else it is at left half
            //if(nums[pivot] > nums[pivot + 1]) return pivot + 1; //????
            if(nums[pivot] > nums[left]) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }
        return 0;
    }
}

package com.po.quiz.search;

public class Q33 {
    Integer len;

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        len = nums.length;
        return onePass(nums, target);
    }

    private int onePass(int[] nums, int target){
        int left = 0, right = len - 1;
        while (left <= right){
            int p = (left + right) / 2;
            if(target == nums[p]) return p;
            else{
                if(nums[p] >= nums[left]){
                    if(target >= nums[left] && target < nums[p])
                        right = p - 1;
                    else
                        left = p + 1;
                } else {
                    if(target > nums[p] && target <= nums[right])
                        left = p + 1;
                    else
                        right = p - 1;
                }
            }
        }
        return -1;
    }

    private int twoPass(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        len = nums.length;
        if (nums[0] == target) return 0;
        int rotate = findRotate(nums);
        if (rotate == 0) {
            return binary(nums, target, 0, len - 1);
        }
        if (target > nums[0])
            return binary(nums, target, 1, rotate - 1);
        else
            return binary(nums, target, rotate, len - 1);
    }

    private int binary(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        int p = (left + right) / 2;
        if (nums[p] == target) return p;
        else if (nums[p] > target) {
            return binary(nums, target, left, p - 1);
        } else {
            return binary(nums, target, p + 1, right);
        }
    }

    private int findRotate(int[] nums) {
        int left = 0, right = len - 1;
        if (nums[left] < nums[right]) return 0;
        while (left <= right) {
            int p = (left + right) / 2;
            if (nums[p] > nums[p + 1]) return p + 1;
            else {
                if (nums[p] < nums[left])
                    right = p - 1;
                else
                    left = p + 1;
            }
        }
        return 0;
    }


    private int mySearch(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int p = (left + right) / 2;
        //pivot == target
        if (nums[p] == target) return p;
        if (target > nums[p]) {
            if (nums[right] > nums[p] && nums[p] > nums[left]) {
                return mySearch(nums, target, p + 1, right);
            } else if (nums[p] > nums[right] && nums[p] > nums[left]) {
                return mySearch(nums, target, p + 1, right);
            } else {
                if (nums[right] > target)
                    return mySearch(nums, target, p + 1, right);
                else
                    return mySearch(nums, target, left, p - 1);
            }
        } else {
            if (nums[right] > nums[p] && nums[p] > nums[left]) {
                return mySearch(nums, target, left, p - 1);
            } else if (nums[p] > nums[right] && nums[p] > nums[left]) {
                if (target >= nums[left])
                    return mySearch(nums, target, left, p - 1);
                else
                    return mySearch(nums, target, p + 1, right);
            } else {
                return mySearch(nums, target, left, p - 1);
            }
        }
    }
}

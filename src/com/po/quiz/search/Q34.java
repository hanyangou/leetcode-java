package com.po.quiz.search;

public class Q34 {
    int[] ans;
    Integer len;
    public int[] searchRange(int[] nums, int target) {
        ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        len = nums.length;
        ans[0] = search(nums, target, 0, len - 1, true);
        ans[1] = search(nums, target, 0, len - 1, false);
        return ans;
    }

    private int search(int[] nums, int target, int left, int right, boolean searchLeft){
        if(left > right) return -1;

        while(left <= right){
            int p = left + (right - left) / 2;
            if(nums[p] == target){
                if(searchLeft){
                    if(p == 0 || nums[p - 1] != target)//found leftmost
                        return p;
                    else
                        right = p -1;
                } else {
                    if(p == len - 1 || nums[p + 1] != target)
                        return p;
                    else
                       left = p + 1;
                }
            } else if(target > nums[p]) { //search right side
                left = p + 1;
            } else { //search left side
                right = p - 1;
            }
        }
        return -1;
    }
}

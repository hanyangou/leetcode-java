package com.po.quiz.binarysearch;

public class Q162 {
    public int findPeakElement(int[] nums) {
        //initially, pick mid element of nums to start
        //determine if mid is in ascending or descending
        //what if mid is peak already? terminate case????

        //corner case [] ???
        //[1]
        //[1 2]
        //[1 2 3 2]
        int left = 0, right = nums.length - 1;
        while(left < right){ //should we consider left == right????
            int mid = (right + left) / 2;
            if(nums[mid] < nums[mid + 1]){ //asc order -- peak is on right side (mid is not possible, exclude it from searching scope)
                left = mid + 1;
            } else { //desc order -- peak is on left side, including mid
                right = mid;
            }
        }
        return left; //when left == right
    }
}

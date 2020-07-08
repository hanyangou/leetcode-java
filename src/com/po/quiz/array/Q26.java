package com.po.quiz.array;

/***
 * two pointers: read and write
 * only advance write ptr when element is not a duplicate
 */
public class Q26 {
    public int removeDuplicates(int[] nums) {
        //corner case?

        //just return if there is only one element in the array
        if(nums.length == 1) return 1;
        int write = 1;
        for(int read = 1; read < nums.length; read++){
            if(nums[read] != nums[read - 1]){
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }
}

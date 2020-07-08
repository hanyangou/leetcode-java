package com.po.quiz.array;

public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0){
            for(int k = 0; k < n; k++){
                nums1[k] = nums2[k];
            }
            return;
        }

        reverse(nums1, m+n);
        int ptr1 = n;
        int ptr2 = n - 1;
        int write = 0;
        while (ptr1 < m + n && ptr2 >= 0){
            if(nums1[ptr1] >= nums2[ptr2]){
                nums1[write++] = nums1[ptr1++];
            } else {
                nums1[write++] = nums2[ptr2--];
            }
        }
        while (ptr1 < m+n){
            nums1[write++] = nums1[ptr1++];
        }
        while (ptr2 >= 0){
            nums1[write++] = nums2[ptr2--];
        }
        reverse(nums1, m+ n);
    }

    private void reverse(int[] nums, int len){
        int left = 0;
        int right = len - 1;
        while (left <= right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}

/***
 *         //in-place merge
 *         //catch up is do not overwrite the element that is not compared yet
 *         //also if there are elements in nums1 not yet compared, how to merge?
 *         //put the smallest one at the end of array
 *         //and reverse the array for the answer
 *         if(n == 0) return;
 *         if(m == 0){
 *             for(int k = 0; k < n; k++){
 *                 nums1[k] = nums2[k];
 *             }
 *             return;
 *         }
 *
 *         //reverse nums1 first
 *         for(int k = 0; k < m/2; k++){
 *             int tmp = nums1[k];
 *             nums1[k] = nums1[m-1-k];
 *             nums1[m-1-k] = tmp;
 *         }
 *
 *         int mi = m + n - 1;
 *         int i = m - 1;
 *         int j = 0;
 *         while(i >= 0 && j < n){
 *             if(nums1[i] <= nums2[j]){
 *                 nums1[mi] = nums1[i];
 *                 i--;
 *             } else {
 *                 nums1[mi] = nums2[j];
 *                 j++;
 *             }
 *             mi--;
 *         }
 *
 *         //nums1 left, already sorted, dont need to do anything
 *         //nums2 left
 *         if(j < n){
 *             for(int k = j; k < n; k++){
 *                 nums1[mi] = nums2[k];
 *                 mi--;
 *             }
 *         }
 *
 *         //reverse final array
 *         for(int k = 0; k < (m + n) / 2; k++){
 *             int tmp = nums1[k];
 *             nums1[k] = nums1[m+n-1-k];
 *             nums1[m+n-1-k] = tmp;
 *         }
 *     }
 */

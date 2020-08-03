package com.po.quiz.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/***
 * modified binary search
 */

public class Q4 {
    int[] nums1;
    int[] nums2;
    int m;
    int n;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.m = nums1.length;
        this.n = nums2.length;
        //corner cases:
        if(nums1.length == 0) {
            if (n % 2 != 0)
                return nums2[(nums2.length - 1) / 2];
            else {
                int mid = (nums2.length - 1) / 2;
                int sum = nums2[mid] + nums2[mid + 1];
                return sum / 2.0;
            }
        }
        if(nums2.length == 0) {
            if (m % 2 != 0)
                return nums1[(nums1.length - 1) / 2];
            else {
                int mid = (nums1.length - 1) / 2;
                int sum = nums1[mid] + nums1[mid + 1];
                return sum / 2.0;
            }
        }

        //make sure m always <= n
        if(nums1.length > nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.m = nums1.length;
        this.n = nums2.length;
        boolean isEven = (m + n) % 2 == 0;

        int left = 0, right = m - 1;
        while (left <= right) { //we terminate if i == m
            int i = left + (right - left) / 2;
            int j = (m + n) / 2 - 2 - i;
            if(j < n - 1 && nums1[i] > nums2[j + 1]){ //i too big
                right = i - 1;
            } else if(i < right && nums1[i+1] < nums2[j]){ //i too small
                left = i + 1;
            } else { //perfect
                int minRight = 0;
                if(i >= m - 1) minRight = nums2[j+1];
                else if(j >= n - 1) minRight = nums1[i+1];
                else
                    minRight = Math.min(nums1[i+1], nums2[j+1]);
                if(!isEven)
                    return minRight;
                //even elements
                int maxLeft = 0;
                if(i < 0) maxLeft = nums2[j];
                else if(j < 0) maxLeft = nums1[i];
                else
                    maxLeft = Math.max(nums1[i], nums2[j]);
                return (minRight + maxLeft) / 2.0;
            }
        }
        int j = (m + n) / 2 - 1;
        int minRight = 0;
        if(j < n - 1) minRight = Math.min(nums1[0], nums2[j + 1]);
        else minRight = nums1[0];
        if(!isEven) return minRight;
        int maxLeft = nums2[j];
        return (minRight + maxLeft) / 2.0;
    }
}

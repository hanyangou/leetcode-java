package com.po.quiz.array;

import java.util.Arrays;

public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //two pointers
        //should we care which array is bigger?

        int idx = 0;
        int left = 0, right = 0;
        int as1 = nums1.length;
        int as2 = nums2.length;
        int[] ans;
        if(as1 > as2) {
            ans = new int[as1];
        } else {
            ans = new int[as2];
        }
        while(left < as1 && right < as2){
            //same value
            //value @ a1 > @a2
            //opposite
            if(nums1[left] == nums2[right]){
                ans[idx++] = nums1[left];
                left++;
                right++;
            } else if(nums1[left] < nums2[right]){
                left++;
            } else {
                right++;
            }
        }
        if(idx == 0) return new int[0];
        ans = Arrays.copyOf(ans, idx); //remove the trailing element that is prefilled during array initialization
        //if question requires no duplication -- various ways for this, try with two pointers for better space complexity
        //corner case: only one element in the array
        // [1 1 2 3 3 ]
        int insertIdx = 0;
        for(int i = 0; i < ans.length - 1; i++){
            if(ans[i] != ans[i + 1]) ans[insertIdx++] = ans[i];
        }
        //adding last e into ans
        ans[insertIdx++] = ans[ans.length - 1];
        return Arrays.copyOf(ans, insertIdx);
    }
}

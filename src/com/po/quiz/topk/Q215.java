package com.po.quiz.topk;

public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, k);
    }

    public int quickselect(int[] nums, int lo, int high, int k){
        if(lo == high) return nums[lo];
        int pivot = partition(nums, lo, high);
        if(pivot == k - 1) return nums[pivot];
        else if(pivot < k - 1) return quickselect(nums, pivot + 1, high, k - pivot - 1);
        else {
            return quickselect(nums, lo, pivot - 1, k);
        }
    }

    /***
     * return final idx of pivot, which is (idx + 1) largest element of the array
     * choosing last element as pivot. loop over array with idx i and swap it with idx j
     * if it's larger than pivot
     */
    public int partition(int[] nums, int lo, int high){
        int pivot = nums[high];
        int idx = lo;
        for(int i = lo; i < high; i++){
            if(nums[i] > pivot) {
                swap(nums, i, idx);
                idx++;
            }
        }
        swap(nums, idx, high);
        return idx;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

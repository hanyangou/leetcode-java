package com.po.quiz;

public class NumArray {
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        if(nums.length == 0) return;
        n = nums.length;
        int x = 0;
        while((int)Math.pow(2, x) < n) x++;
        tree = new int[(int)Math.pow(2, x) * 2 - 1];
        build(nums, 0, 0, n - 1);
    }

    private void build(int[] arr, int idx, int lo, int hi){
        if(lo == hi){
            tree[idx] = arr[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        build(arr, idx * 2 + 1, lo, mid);
        build(arr, idx * 2 + 2, mid + 1, hi);
        tree[idx] = tree[idx * 2 +  1] + tree[idx * 2 + 2];
    }

    public void update(int i, int val) {
        update(0, 0, n - 1, i, val);
    }

    public void update(int tIdx, int lo, int hi, int aIdx, int val){
        if(lo == hi){
            tree[tIdx] = val;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if(aIdx > mid)
            update(tIdx * 2 + 2, mid + 1, hi, aIdx, val);
        else
            update(tIdx * 2 + 1, lo, mid, aIdx, val);
        tree[tIdx] = tree[tIdx * 2 + 1] + tree[tIdx * 2 + 2];
    }

    public int sumRange(int i, int j) {
        return sumRange(0, 0, n - 1, i, j);
    }

    public int sumRange(int idx, int lo, int hi, int i, int j){
        if(lo > j || hi < i) return 0;
        if(lo >= i && hi <= j) return tree[idx];
        int mid = lo + (hi - lo) / 2;
        if(i > mid)
            return sumRange(idx * 2+ 2, mid + 1, hi, i, j);
        if(j <= mid)
            return sumRange(idx * 2 + 1, lo, mid, i, j);
        int left = sumRange(idx * 2 + 1, lo, mid, i, mid);
        int right = sumRange(idx * 2 + 2, mid + 1, hi, mid + 1, j);
        return left + right;
     }
}

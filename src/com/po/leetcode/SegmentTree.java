package com.po.leetcode;

public class SegmentTree {
    int[] tree;
    int n;
    public SegmentTree(int n){
        int x = 0;
        this.n = n;
        while (Math.pow(2, x) < n) x++;
        tree = new int[2 * (int)Math.pow(2, x) - 1];
    }

    public void build(int[] arr){
        build(arr, 0, 0, arr.length - 1);
    }

    public void build(int[] arr, int idx, int lo, int hi){
        if(lo == hi){
            tree[idx] = arr[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        build(arr, 2 * idx + 1, lo, mid);
        build(arr, 2 * idx + 2, mid + 1, hi);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    public int query(int i , int j){
        return query(0, 0, n - 1, i, j);
    }

    public int query(int idx, int lo, int hi, int i, int j){
        //segment in the range
        //segment outside of range
        //partial in the range
        if(hi < i || lo > j) return 0;
        if(lo >= i && hi <= j) return tree[idx];
        int mid = lo + (hi - lo) / 2;
        if(i > mid)
            return query(idx * 2 + 2, mid + 1, hi, i, j);
        if(j <= mid)
            return query(idx * 2 + 1, lo, mid, i, j);
        int left = query(idx * 2 + 1, lo, mid, i, j);
        int right = query(idx * 2 + 2, mid + 1, hi, i, j);
        return left + right;
    }

    public void update(int idx, int val){
        update(0, 0, n - 1, idx, val);
    }

    public void update(int treeIdx, int lo, int hi, int arrIdx, int val){
        if(lo == hi){
            tree[treeIdx] = val;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if(arrIdx > mid){
            update(treeIdx * 2 + 2, mid + 1, hi, arrIdx, val);
        } else {
            update(treeIdx * 2 + 1, lo, mid, arrIdx, val);
        }
        tree[treeIdx] = tree[treeIdx * 2 + 1] + tree[treeIdx * 2 + 2];
    }

    public void print(){
        return;
    }
}

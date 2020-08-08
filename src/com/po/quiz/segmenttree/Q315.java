package com.po.quiz.segmenttree;

import java.util.*;

public class Q315 {
    class SegmentTreeNode {
        int max;
        int min;
        int count;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int min, int max){
            this.max = max;
            this.min = min;
            count = 0;
        }
        public int getMid(){
            return min + (max - min) / 2;
        }
    }

    SegmentTreeNode root;
    public List<Integer> countSmaller(int[] nums) {
        //corner base
        int[] copy = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            copy[i] = nums[i];
        }
        Map<Integer, Integer> mapper = new HashMap<>();
        Arrays.sort(copy);
        for(int i = 0; i < copy.length; i++){
            mapper.put(copy[i], i);
        }
        root = new SegmentTreeNode(0, nums.length - 1);
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
            res.add(0, find(root, mapper.get(nums[i])));
            update(root, mapper.get(nums[i]));
        }
        return res;
    }

    /***
     *  if val > node.max, return node.count
     *  otherwise travel to next child node based on mid value
     *  return 0 if node is null
     */
    public int find(SegmentTreeNode node, int target){
        if(node == null) return 0;
        if(target > node.max) {
            return node.count;
        }
        int mid = node.getMid();
        if(target > mid)
            return find(node.right, target) + find(node.left, target);
        else
            return find(node.left, target);
    }

    /***
     * update node.count + 1
     * update min/max if necessary
     * recursive until ???
     */
    public void update(SegmentTreeNode node, int add){
        if(add < node.min || add > node.max) return;
        node.count++;
        if(node.min == node.max) return;
        int mid = node.getMid();
        if(add <= mid){
            if(node.left == null){
                node.left = new SegmentTreeNode(node.min, mid);
            }
            update(node.left, add);
        } else {
            if(node.right == null){
                node.right = new SegmentTreeNode(mid + 1,  node.max);
            }
            update(node.right, add);
        }
    }
}

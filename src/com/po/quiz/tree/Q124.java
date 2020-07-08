package com.po.quiz.tree;

import com.po.leetcode.TreeNode;

public class Q124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node){
        if(node == null) return 0;
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int newPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, newPath);
        return node.val + Math.max(leftGain, rightGain);
    }
}

package com.po.quiz.tree;

import com.po.leetcode.TreeNode;

public class Q543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //iterate thru all nodes to get their diameters
        helper(root);
        return max;
    }

    private void helper(TreeNode node){
        if(node == null) return;
        max = Math.max(max, getDiameter(node));
        if(node.left != null) helper(node.left);
        if(node.right != null) helper(node.right);
    }

    private int getDiameter(TreeNode node){
        int diameter = 0;
        if(node.left != null)
            diameter += getLength(node.left) + 1;
        if(node.right != null)
            diameter += getLength(node.right) + 1;

        return diameter;
    }

    private int getLength(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 0;
        return 1 + Math.max(getLength(node.left), getLength(node.right));
    }
}

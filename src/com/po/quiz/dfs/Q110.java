package com.po.quiz.dfs;

import com.po.leetcode.TreeNode;

public class Q110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(getLevel(root.left) - getLevel(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getLevel(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(getLevel(node.left), getLevel(node.right));
    }
}

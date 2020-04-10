package com.po.quiz.dfs;

import com.po.leetcode.TreeNode;

public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if (p != null && q != null) {
            if(p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else return false;
    }
}

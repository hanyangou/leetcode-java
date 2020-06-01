package com.po;

import com.po.algo.Tree;
import com.po.leetcode.TreeNode;

public class Main {

    public static void main(String[] args) {
        String in = "4 8 2 5 1 6 3 7";
        String post = "8 4 5 2 6 7 3 1";
        TreeNode root = Tree.deserialize(post, in);
        Tree.dfs(root);
    }
}

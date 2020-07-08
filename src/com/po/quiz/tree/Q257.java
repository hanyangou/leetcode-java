package com.po.quiz.tree;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<List<TreeNode>> paths = new ArrayList<>();
        if(root == null) return res;
        dfs(root, new ArrayList<>(), paths);
        for(List<TreeNode> path: paths){
            convert(res, path);
        }
        return res;
    }

    private void convert(List<String> res, List<TreeNode> path){
        StringBuilder sb = new StringBuilder();
        for(TreeNode node : path){
            sb.append(node.val);
            sb.append("->");
        }
        sb.delete(sb.length() - 2, sb.length());
        res.add(sb.toString());
    }

    private void dfs(TreeNode node, List<TreeNode> path, List<List<TreeNode>> paths){
        //base case: node is null, return
        if(node == null) return;
        //base case: reach leaf, put path into paths
        path.add(node);
        if(node.left == null && node.right == null){
            paths.add(new ArrayList<>(path));
            return;
        }
        dfs(node.left, new ArrayList<>(path), paths);
        dfs(node.right, new ArrayList<>(path), paths);
    }
}

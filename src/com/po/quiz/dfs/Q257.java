package com.po.quiz.dfs;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;

        List<List<Integer>> paths = new ArrayList<>();
        dfs(root, paths, new ArrayList<>());


        for(List<Integer> path : paths){
            convert(path, ans);
        }
        return ans;
    }

    private void convert(List<Integer> path, List<String> ans){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i <= path.size() - 2; i++){
            sb.append(path.get(i));
            sb.append("->");
        }
        sb.append(path.get(path.size() - 1));
        ans.add(sb.toString());
    }

    private void dfs(TreeNode node, List<List<Integer>> paths, List<Integer> path){
        path.add(node.val);
        if(isLeaf(node)){
            paths.add(path);
            return;
        }
        if(node.left != null) dfs(node.left, paths, new ArrayList<>(path));
        if(node.right != null) dfs(node.right, paths, new ArrayList<>(path));
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}

package com.po.quiz.dfs;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, res, new ArrayList<>(), sum);
        return res;
    }

    //store node val in interim list
    //if node is leaf, push interim list into general list
    private void dfs(TreeNode node, List<List<Integer>> paths, List<Integer> path, int sum){
        path.add(node.val);
        if(isLeaf(node)){
            int total = 0;
            for(Integer i : path){
                total += i;
            }
            if(total == sum) paths.add(path);
            return;
        } else {
            if(node.left != null) dfs(node.left, paths, new ArrayList<>(path), sum);
            if(node.right != null) dfs(node.right, paths, new ArrayList<>(path), sum);
        }
    }

    //check if a node is a leaf
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}

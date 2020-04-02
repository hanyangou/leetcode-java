package com.po.quiz.dfs;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q112 {

    //dfs:
    //add current node into sub list
    //if node is leave, add to paths
    //if node has branches, call next level

    public boolean hasPathSum(TreeNode root, int sum) {
        //corner case:
        if(root == null) return false;
        //dfs
        //get sum from root to leave
        //break and return true if found
        //os return false after traveling through all branches
        List<List<Integer>> paths = new ArrayList<>();
        return  dfs(root, new ArrayList<>(), sum);
    }

    private boolean dfs(TreeNode node, List<Integer> subpath, int sum){
        subpath.add(node.val);
        if(isLeave(node)) {
            int total = 0;
            for(Integer i : subpath){
                total += i;
            }
            return total == sum;
        } else {
            boolean res = false;
            if(node.left != null) res = res | dfs(node.left, new ArrayList<>(subpath), sum);
            if(node.right != null) res = res | dfs(node.right, new ArrayList<>(subpath), sum);

            return res;
        }
    }

    private boolean isLeave(TreeNode node){
        return node.left == null && node.right == null;
    }
}

package com.po.quiz.dfs;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q437 {
    private int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        //build dfs first
        List<List<Integer>> paths = new ArrayList<>();
        dfs(root, new ArrayList<>(), sum);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> path, int sum){
        for(int i = 0; i < path.size(); i++){
            int remain = path.get(i) + node.val;
            if(remain == sum) ans++;
            path.set(i, remain);
        }

        if(node.val == sum) ans++;
        path.add(node.val);

        if(node.left != null) dfs(node.left, new ArrayList<>(path), sum);
        if(node.right != null) dfs(node.right, new ArrayList<>(path), sum);
    }
}

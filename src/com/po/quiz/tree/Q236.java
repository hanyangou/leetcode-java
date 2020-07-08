package com.po.quiz.tree;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //dfs to each node -- and find out the common ancestor
        List<TreeNode> ancestorsP =  new ArrayList<>();
        dfs(root, p, ancestorsP);
        List<TreeNode> ancestorsQ =  new ArrayList<>();
        dfs(root, q, ancestorsQ);
        List<TreeNode> common =  new ArrayList<>();
        for(TreeNode n : ancestorsP){
            if(ancestorsQ.contains(n)) common.add(n);
        }
        return common.get(common.size() - 1);
    }

    private boolean dfs(TreeNode node, TreeNode target, List<TreeNode> ancestors){
        if(node == null) return false;

        //found target
        if(node.val == target.val){
            ancestors.add(node);
            return true;
        }
        //this is child node and not found target, backtrack
        if(node.left == null && node.right == null){
            return false;
        }
        ancestors.add(node);
        //search next child nodes
        if(dfs(node.left, target, ancestors) || dfs(node.right, target, ancestors)){
            return true;
        } else {
            ancestors.remove(ancestors.size() - 1); //not round, backtrack
            return false;
        }
    }
}

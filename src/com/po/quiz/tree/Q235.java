package com.po.quiz.tree;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ancesP = new ArrayList<>();
        List<TreeNode> ancesQ = new ArrayList<>();
        findAnces(root, p, ancesP);
        findAnces(root, q, ancesQ);
        List<TreeNode> res = new ArrayList<>();
        for(TreeNode node : ancesP){
            if(ancesQ.contains(node)) res.add(node);
        }

        return res.get(res.size() - 1);
    }

    private void findAnces(TreeNode node, TreeNode target, List<TreeNode> list){
        if(node == null) return;
        list.add(node);
        if(node.val == target.val){
          return;
        }
        if(node.val < target.val){ //target is on right side
            findAnces(node.right, target, list);
        } else { //ow its on left
            findAnces(node.left, target, list);
        }
    }
}

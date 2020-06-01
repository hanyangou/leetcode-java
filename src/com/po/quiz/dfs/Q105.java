package com.po.quiz.dfs;

import com.po.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    int preorderIdx = 0;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        for(int i = 0; i <  inorder.length; i ++){
            idxMap.put(inorder[i], i);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int inLeft, int inRight){
        if(inLeft == inRight) return null;
        int nodeVal = preorder[preorderIdx];
        preorderIdx++;
        TreeNode node = new TreeNode(nodeVal);
        int inNodeIdx = idxMap.get(nodeVal);
        node.left = helper(inLeft, inNodeIdx);
        node.right = helper(inNodeIdx + 1, inRight);
        return node;
    }
}

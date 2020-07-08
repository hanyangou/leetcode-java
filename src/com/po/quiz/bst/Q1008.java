package com.po.quiz.bst;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class Q1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return null;
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        for(int i : preorder){
            pre.add(i);
            in.add(i);
        }
        Collections.sort(in);
        return helper(in, pre, 0, in.size() - 1);
    }

    public TreeNode helper(ArrayList<Integer> inorder, ArrayList<Integer> preorder, int inStart, int inEnd){
        if(preorder.size() == 0 || inStart > inEnd) return null;
        int rootVal = preorder.remove(0);
        TreeNode root = new TreeNode(rootVal);
        int idx = inorder.indexOf(rootVal);
        root.left = helper(inorder, preorder, inStart, idx - 1);
        root.right = helper(inorder, preorder, idx + 1, inEnd);
        return root;
    }
}

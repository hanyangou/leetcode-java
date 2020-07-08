package com.po.quiz.bst;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * inorder traversal and compare the if value is in ascending order
 */
public class Q98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root!= null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            inorder.add(root.val);
            root = root.right;
        }
        for(int i = 0; i < inorder.size() - 1; i++){
            if(inorder.get(i) >= inorder.get(i + 1)) return false;
        }
        return true;
    }
}

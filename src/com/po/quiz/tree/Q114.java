package com.po.quiz.tree;

import com.po.leetcode.TreeNode;

/***
 * in-place???
 * inorder traversal
 * cannot use additional data structure to hold the node
 */
public class Q114 {
    public void flatten(TreeNode root) {
        recursive(root);
    }

    private TreeNode recursive(TreeNode node){
        //base case: return node when it is a leaf
        if(node == null) return null;
        if(node.left == null && node.right == null) return node;
        //get tail on left node
        //get tail on right node
        TreeNode leftTail = recursive(node.left);
        TreeNode rightTail = recursive(node.right);
        //do following if leftTail is not null
        //node.right = left node
        //leftTail.right = node.right
        //node.left = null
        if(leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rightTail == null? leftTail : rightTail;
    }
}

package com.po.quiz.tree;

import com.po.leetcode.TreeNode;

/***
 * BST to sorted Circular Doubly-Linked List -- inorder traversal
 * change it in-place
 * recursive -- return pointer
 *
 */
public class Q426 {
    TreeNode first;
    TreeNode last;
    public TreeNode treeToDoublyList(TreeNode root) {
        first = null;
        last = null;
        if(root == null) return null;
        helper(root);
        //close the list
        first.left = last;
        last.right = first;
        return first;
    }

    private void helper(TreeNode node){
        if(node != null){
            helper(node.left);
            if(last != null){
                last.right = node;
                node.left = last;
            } else {
                first = node;
            }
            last = node;
            helper(node.right);
        }
    }
}

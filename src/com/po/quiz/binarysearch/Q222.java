package com.po.quiz.binarysearch;

import com.po.leetcode.TreeNode;

public class Q222 {
    //calculate the total depth of tree.... dfs to left most branch
    //total nodes in d-1 depth is 2 ^ (d-1)
    //using binary search to determine which node exists
    //during this process, using the same way how binary search iterates to navigate to proper node
    public int countNodes(TreeNode root) {
        //corner case: root is null
        if(root == null) return 0;

        int d = getDepth(root) - 1; //start with 0
        //calculate total nodes for the tree besides leave level
        int total = (int) Math.pow(2, d) - 1;

        //binary search to see how many leaves
        //terminate case??
        int left = 0;
        int right = (int)Math.pow(2, d) - 1;
        int lastExistLeaf = -1;
        while(left <= right){
            int pivot = left + (right - left) / 2;
            if(exist(root, pivot, d)){ //node exist -- check right side
                lastExistLeaf = pivot;
                left = pivot + 1;
            } else {
                right = pivot - 1;            }
        }

        if(lastExistLeaf == -1) return total;
        else return total + lastExistLeaf + 1;
    }

    //check if leaf exists in given idx
    public boolean exist(TreeNode node, int idx, int d) {
        //calculate total nodes by left and right, and split it with middle node
        //node idx is incremental since it is the location idx, range is 0 to (2 ^ d) - 1
        //find out idx locating in which half, advance to left/right child node
        int left = 0, right = (int)Math.pow(2, d) - 1;
        int pivot;
        for(int i = 0; i < d; i++){
            // 3 4 5 6
            pivot = left + (right - left) / 2;
            if(idx <= pivot) { //going left
                right = pivot;
                node = node.left;
            } else { //going right
                left = pivot + 1;
                node = node.right;
            }
        }
        return node != null;

    }

    //get total levels for given node
    //special case: travel through left-most branch
    private int getDepth(TreeNode node){
        //termination case: when node is null
        if(node == null) return 0;
        //depth of this node = 1 + max of depth from branch
        //dont worry about if branch is null, it got taken care with termination case
        return 1 + getDepth(node.left);
    }
}

package com.po.quiz.bfs;

import com.po.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        //pair: node, level
        queue.add(new Pair(root, 1));
        int ans = 0;
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            int level = p.l;
            ans = level;
            TreeNode node = p.t;
            if(node.left == null && node.right == null) return ans;
            if(node.left != null) queue.add(new Pair(node.left, level+1));
            if(node.right != null) queue.add(new Pair(node.right, level+1));
        }
        return ans;
    }

    class Pair{
        TreeNode t;
        int l;
        Pair(TreeNode node, int level) {
            t = node;
            l = level;
        }
    }
}

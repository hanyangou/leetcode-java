package com.po.quiz.tree;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * first using BFS to build nodes for each level
 * put rightmost node into result list
 */
public class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        bfs(res, queue); //O(n)
        return res;
    }

    public void bfs(List<Integer> res, Queue<TreeNode> queue){
        if(queue.isEmpty()) return;

        Queue<TreeNode> nextLevelQueue = new LinkedList<>();
        while (queue.size() > 1){
            TreeNode node = queue.poll();
            if(node.left != null) nextLevelQueue.offer(node.left);
            if(node.right != null) nextLevelQueue.offer(node.right);
        }

        TreeNode last = queue.poll();
        res.add(last.val);
        if(last.left != null) nextLevelQueue.offer(last.left);
        if(last.right != null) nextLevelQueue.offer(last.right);
        bfs(res, nextLevelQueue);
    }
}

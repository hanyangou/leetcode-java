package com.po.quiz.tree;

import com.po.leetcode.TreeNode;

import java.util.*;

public class Q341 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        //bfs
        Map<Integer, List<Integer>> cols = new HashMap<>();
        Map<TreeNode, Integer> nodeToCol = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> col = cols.getOrDefault(0, new ArrayList<>());
        col.add(root.val);
        cols.put(0, col);
        nodeToCol.put(root, 0);
        queue.offer(root);
        int min = 0;
        int max = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            int level = nodeToCol.get(node);
            if(node.left != null){
                int nLevel = level - 1;
                nodeToCol.put(node.left, nLevel);
                List<Integer> c = cols.getOrDefault(nLevel, new ArrayList<>());
                c.add(node.left.val);
                cols.put(nLevel, c);
                min = Math.min(min, nLevel);
                queue.offer(node.left);
            }
            if(node.right != null){
                int nLevel = level + 1;
                nodeToCol.put(node.right, nLevel);
                List<Integer> c = cols.getOrDefault(nLevel, new ArrayList<>());
                c.add(node.right.val);
                cols.put(nLevel, c);
                max = Math.max(max, nLevel);
                queue.offer(node.right);
            }
        }

        for(int i = min; i <= max; i++){
            if(!cols.containsKey(i)) continue;
            List<Integer> list = cols.get(i);
            res.add(list);
        }

        return res;
    }
}

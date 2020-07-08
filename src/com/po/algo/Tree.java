package com.po.algo;

import com.po.leetcode.TreeNode;

import java.util.*;

public class Tree {
    //using arraydeque instead of stack
    public static void dfs(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            sb.append(root.val);
            sb.append(" ");
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }

    public static TreeNode deserialize(String post, String in){
        String[] posts = post.split(" ");
        String[] ins = in.split(" ");
        ArrayList<String> postList = new ArrayList<>();
        for(String str: posts) postList.add(str);
        ArrayList<String> inList = new ArrayList<>();
        for(String str: ins) inList.add(str);
        return build(postList, inList, 0, ins.length - 1);
    }

    private static TreeNode build(ArrayList<String> posts, ArrayList<String> ins, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        int val = Integer.parseInt(posts.remove(posts.size() - 1));
        TreeNode root = new TreeNode(val);
        int inIdx = ins.indexOf(String.valueOf(val));
        root.right = build(posts, ins, inIdx + 1, inEnd);
        root.left = build(posts, ins, inStart, inIdx - 1);
        return root;
    }
}

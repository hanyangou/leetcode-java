package com.po.quiz.design;

import com.po.leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Codec {
    private String NULL = "null";
    private String COMMA = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(root == null){
            sb.append(NULL);
            sb.append("]");
            return sb.toString();
        }

        //dfs
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(sb.charAt(sb.length() - 1) != '['){
                sb.append(COMMA);
            }
            if(node == null){
                sb.append(NULL);
            } else {
                sb.append(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;

        data = data.substring(1, data.length() - 1); //remove '[' and ']'
        if(data.length() == 0) return null; //for case : []

        String[] strs = data.split(",");
        return deserializeHelper(new LinkedList<>(Arrays.asList(strs)));
    }

    private TreeNode deserializeHelper(List<String> list){
        String val = list.get(0);
        list.remove(0);
        if(val.equals(NULL)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);
        return node;
    }
}

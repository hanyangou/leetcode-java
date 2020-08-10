package com.po.quiz.design;

import com.po.leetcode.TreeNode;

import java.util.*;

/***
 * which tree traversal ensure the sequence???
 *
 */

public class Codec {
    static String DELIMITER = ",";
    static String NULL = "#";
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private static void serializeHelper(TreeNode node, StringBuilder sb){
        if(node == null) {
            sb.append(NULL);
            sb.append(DELIMITER);
            return;
        }
        sb.append(node.val);
        sb.append(DELIMITER);
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] d = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(d));
        return dHelper(list);
    }

    private static TreeNode dHelper(List<String> list){
        String s = list.get(0);
        list.remove(0);
        if(s.equals(NULL)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = dHelper(list);
        node.right = dHelper(list);
        return node;
    }
}

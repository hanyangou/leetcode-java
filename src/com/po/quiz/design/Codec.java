package com.po.quiz.design;

import com.po.leetcode.TreeNode;

import java.util.*;

/***
 * which tree traversal ensure the sequence???
 *
 */

public class Codec {
    String DELIMITER = ",";
    String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return null;
    }

    private void serializeHelper(TreeNode node, StringBuilder sb){
        if(node == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(node);
        while(node != null && !stack.isEmpty()){
            node = stack.pop();
            sb.append(node.val);
            sb.append(DELIMITER);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}

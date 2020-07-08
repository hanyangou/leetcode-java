package com.po.quiz.bst;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q449 {
    private String delimeter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        //postorder: left right center
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
            sb.append(delimeter);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void postorder(TreeNode node, List<Integer> list){
        if(node == null) return;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] strs = data.split(delimeter);
        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> postorder = new ArrayList<>();
        for(String str: strs) {
            inorder.add(Integer.valueOf(str));
            postorder.add(Integer.valueOf(str));
        }
        Collections.sort(inorder);
        return build(inorder, postorder, 0, inorder.size() - 1);
    }

    //1, root = post[last]
    //2. idx = inorder.indexOf(root)
    //3. root.right = build(idx + 1, inEnd)
    //4. root.left = build(inStart, idx - 1)
    private TreeNode build(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        int rootVal = postorder.remove(postorder.size() - 1);
        TreeNode root = new TreeNode(rootVal);
        int idx = inorder.indexOf(rootVal);
        root.right = build(inorder, postorder, idx + 1, inEnd);
        root.left = build(inorder, postorder, inStart, idx - 1);
        return root;
    }
}

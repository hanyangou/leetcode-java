package com.po.quiz.tree;

import com.po.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * thoughts: this question is the combo of two techniques:
 *  1) serialize tree to a serial int/str
 *  2) using an incremental id to represent an uid of object.
 *
 *
 *  the first approach is concatenating id from each sub-string, which takes O(n), since for each of node, the string
 *  concatenation takes O(N) and performs N times. which total time complexity is O(N ^ 2)
 *  we can reduce it by removing the overhead of string concatenation, with the replacement of using uid for each of sub-tree.
 *  consider a well-balanced tree with node 0 - 6, the original id is 0,1,3,4,2,5,6 VS with assigned UID is 0,2,5 -- where 2 is uid of
 *  root.left and 5 is the uid of root.right
 *  By this approach, the time complexity of id serialization reduces from O(n) to O(1), since the length of serialization no longer
 *  increase linearly whiling visiting nodes.
 *
 */
public class Q652 {
    public String delimiter = ",";
    public int t = 1; //starting from 1 since 0 is reserved for null
    public Map<String, Integer> ids;
    public Map<Integer, Integer> counts;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        counts = new HashMap<>();
        ids = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        process(root, res); //O(N), process each node once
        return res;
    }
    //recursively generate id for sub-tree and append it to parent
    //node.val + delimiter + id(node.left) + delimiter + id(node.right)
    //generate id and put it into map with counter
    public int process(TreeNode node, List<TreeNode> res){
        if(node == null) return 0;
        String id = String.valueOf(node.val) + delimiter + process(node.left, res) + delimiter + process(node.right, res);
        int uid = ids.computeIfAbsent(id, x -> t++);
        int count = counts.getOrDefault(uid, 0) + 1; //O(1)
        counts.put(uid, count);
        if(count == 2){
            res.add(node);
        }
        return uid;
    }
}

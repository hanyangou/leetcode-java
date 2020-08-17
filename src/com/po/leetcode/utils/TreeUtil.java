package com.po.leetcode.utils;

import com.po.leetcode.TreeNode;
import com.po.quiz.design.Codec;

public class TreeUtil {
    public static TreeNode tree(String val){
        return Codec.deserialize(val);
    }
}

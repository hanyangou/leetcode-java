package com.po;
import com.po.leetcode.TreeNode;
import com.po.leetcode.utils.TreeUtil;

public class Main {

    public static void main(String[] args)
    {
        TreeNode node = TreeUtil.tree("0,1,3,#,4,#,#,5,6,#,#,#,2,#,7,#,#");
        return;
    }

    public static String ip(String ip) {
        int dot = 0;
        for (char c : ip.toCharArray()) {
            if (c == '.') dot++;
        }
        if (dot == 3) return "ip4";
        int colon = 0;
        for (char c : ip.toCharArray()) {
            if (c == ':') colon++;
        }
        if (colon == 7) return "ip6";
        return "Neither";

    }

    public static void print(String str) {
        System.out.println(str);
    }
}

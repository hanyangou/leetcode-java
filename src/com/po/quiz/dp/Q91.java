package com.po.quiz.dp;

import java.util.HashMap;

public class Q91 {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        return recursive(s, 0);
    }

    public int recursive(String s, int idx){
        if(idx == s.length()) return 1;
        if(s.charAt(idx) == '0') return 0;
        if(idx == s.length() - 1) return 1;
        if(memo.containsKey(idx)) return memo.get(idx);
        int ans = recursive(s, idx+1);
        if(Integer.parseInt(s.substring(idx, idx+2)) <= 26)
            ans += recursive(s, idx + 2);
        memo.put(idx, ans);
        return ans;
    }
}

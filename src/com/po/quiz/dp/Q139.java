package com.po.quiz.dp;

import java.util.List;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = wordDict.contains(s.substring(0,1));
        for(int i = 1; i < s.length(); i++){
            if(wordDict.contains(s.substring(0, i+1))){
                dp[i] = true;
                continue;
            }
            for(int j = 0; j < i; j++){
                if(dp[j]){
                    dp[i] = wordDict.contains(s.substring(j+1,i+1));
                    if(dp[i]) break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}

package com.po.quiz.string;

public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        String res = "";
        for(int i = 0; i < strs.length; i++){
            String s1 = strs[i];
            String s2;
            if(i == 0){
                s2 = strs[i+1];
            } else {
                s2 = res;
            }
            int j = 0;
            while (j < Math.min(s1.length(), s2.length())){
                if(s1.charAt(j) != s2.charAt(j)) break;
                j++;
            }
            res = s1.substring(0, j);
        }
        return res;
    }
}

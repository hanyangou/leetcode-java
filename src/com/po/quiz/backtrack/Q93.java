package com.po.quiz.backtrack;

import java.util.ArrayList;
import java.util.List;

/***
 * constraint: 1. 0-255 2. four digits
 * termination case: contain 4 digits
 * challenge: how to chop string
 * special case: 0000
 * special case: 11111111111111111111111111111111111111
 */

public class Q93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() > 12) return res;
        backtrack(s, res, new ArrayList<>(), -1, 0);
        return res;
    }

    public void backtrack(String s, List<String> res, List<String> segment, int prev, int dots){
        //termination
        if(dots == 4 && prev == s.length() - 1){
            StringBuilder sb= new StringBuilder();
            for(String str : segment){
                sb.append(str);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1); //remove last "."
            res.add(sb.toString());
            return;
        }
        //backtrack
        for(int curr = prev + 1; curr < s.length(); curr++){
            String ip = s.substring(prev + 1, curr + 1);
            //place
            if(validIP(ip)){
                segment.add(ip);
                //backtrack
                backtrack(s, res, segment, curr, dots + 1);
                //remove
                segment.remove(segment.size() - 1);
            }
        }
    }

    public boolean validIP(String str){
        return (str.charAt(0) == '0' && str.length() == 1) || str.charAt(0) != '0' && str.length() <= 3 && Integer.valueOf(str) >= 0 && Integer.valueOf(str) <= 255;
    }
}

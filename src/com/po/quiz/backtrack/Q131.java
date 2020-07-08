package com.po.quiz.backtrack;

import java.util.ArrayList;
import java.util.List;

/***
 * constraint: palindrome
 *
 * algorithm: cut out substring from prev + 1 to curr + 1 (because end ptr of substring is exclusive) and make sure it is palindrome.
 *
 * write a method to check if str is palindrome
 */
public class Q131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        //corner case
        if(s == null || s.length() == 0) return res;
        backtrack(res, new ArrayList<>(), s, -1);
        return res;
    }

    public void backtrack(List<List<String>> res, List<String> subs, String str, int prev){
        if(prev == str.length() - 1){
            res.add(new ArrayList<>(subs));
        }
        for(int curr = prev + 1; curr < str.length(); curr++){
            String sub = str.substring(prev + 1, curr + 1);
            //choose
            //explore
            //unchoose
            if(isPalindrome(sub)){
                subs.add(sub);
                backtrack(res, subs, str, curr);
                subs.remove(subs.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str){
        int left = 0, right = str.length() - 1;
        while (left <= right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

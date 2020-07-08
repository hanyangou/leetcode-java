package com.po.quiz.string;

public class Q125 {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2) return true;
        s = s.toLowerCase();
        int low = 0;
        int high = s.length() - 1;
        while (low <= high){
            //out of boundary problem
            boolean shouldBreak = false;
            while (low <= high && !Character.isLetterOrDigit(s.charAt(low))){
                low++;
            }
            while (low <= high && !Character.isLetterOrDigit(s.charAt(high))){
                high--;
            }

            if(low > high) break;
            char lc = s.charAt(low);
            char hc = s.charAt(high);
            if(lc != hc) return false;
            low++;
            high--;
        }
        return true;
    }
}

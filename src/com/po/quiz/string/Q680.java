package com.po.quiz.string;

public class Q680 {
    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, false);
    }

    public boolean valid(String s, int low, int high, boolean usedSkip){
        if(low > high) return true;
        char lc = s.charAt(low);
        char hc = s.charAt(high);
        if(lc != hc){
            if(usedSkip) return false;
            else {
                return valid(s, low + 1, high, true) || valid(s, low, high - 1, true);
            }
        }
        return valid(s, low + 1, high - 1, usedSkip);
    }
}

/***
 public boolean validPalindrome(String s) {
 return validPalindrome(s, 0, s.length() - 1, false);
 }

 public boolean validPalindrome(String s, int left, int right, boolean usedSkip){
 while (left <= right){
 if(s.charAt(left) != s.charAt(right)){
 if(usedSkip) return false;
 else {
 return validPalindrome(s, left + 1, right, true) || validPalindrome(s, left, right - 1, true);
 }
 }
 left++;
 right--;
 }
 return true;
 }



 */

package com.po.quiz.backtrack;

public class Q10 {
    public boolean isMatch(String s, String p) {
        if(s.isEmpty()) {
            if(p.length() >= 2 && p.charAt(1) == '*')
                return isMatch(s, p.substring(2));
            else
                return p.isEmpty();
        }
        //s still has letter(s) but p is empty
        if(p.isEmpty())
            return false;
        //p has no * at second char
        if(p.length() >= 2 && p.charAt(1) == '*'){
            if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            else
                return isMatch(s, p.substring(2));
        } else {
            if(s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')
                return false;
            else
                return isMatch(s.substring(1), p.substring(1));
        }
    }
}

/***
 public boolean isMatch(String s, String p) {
 if(s.isEmpty()) {
 if(p.length() >= 2 && p.charAt(1) == '*')
 return isMatch(s, p.substring(2));
 else
 return p.isEmpty();
 }
 //s still has letter(s) but p is empty
 if(p.isEmpty())
 return false;
 boolean firstMatch = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
 //p has no * at second char
 if(p.length() >= 2 && p.charAt(1) == '*'){
 return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
 } else {
 return firstMatch && isMatch(s.substring(1), p.substring(1));
 }
 }
***/


//fail
/***
 class Solution {
 public boolean isMatch(String s, String p) {
 if(s.isEmpty()) {
 if(p.length() >= 2 && p.charAt(1) == '*')
 return isMatch(s, p.substring(2));
 else
 return p.isEmpty();
 }
 //s still has letter(s) but p is empty
 if(p.isEmpty())
 return false;
 //p has no * at second char
 if(p.length() >= 2 && p.charAt(1) == '*'){
 if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
 return isMatch(s.substring(1), p) || isMatch(s.substring(1), p.substring(2)) || isMatch(s, p.substring(2));
 else
 return isMatch(s, p.substring(2));
 } else {
 if(s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')
 return false;
 else
 return isMatch(s.substring(1), p.substring(1));
 }
 }
 }
 ***/
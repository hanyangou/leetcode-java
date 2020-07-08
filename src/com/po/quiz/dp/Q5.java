package com.po.quiz.dp;

/***
 * dynamic programming: if we found a palindrome string P, then xPy is also a palindrom if x == y
 * initial case: P(i,i) = true, P(i, i+1) = Si == Si+1
 * expand around the center: center can be 1 character or between two characters
 * aba OR abba
 */
public class Q5 {
    int start, max;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        start = 0;
        max = 1;

        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++){
            center(cs, i-1, i+1);
            if(i < cs.length - 1 && cs[i] == cs[i+1])
                center(cs, i-1, i+2);
        }
        return s.substring(start, start + max);
    }

    public void center(char[] cs, int left, int right){
        if(left < 0 || right >= cs.length) {
            left++;
            right--;
            int len = right - left + 1;
            if(len > max){
                max = len;
                start = left;
            }
            return;
        }
        while (left >= 0 && right < cs.length && cs[left] == cs[right]){
            left--;
            right++;
        }
        left++;
        right--;
        int len = right - left + 1;
        if(len > max){
            max = len;
            start = left;
        }
    }
}


/***
 *     int start, max;
 *     public String longestPalindrome(String s) {
 *         if(s == null || s.length() <= 1) return s;
 *
 *         for(int i = 0; i < s.length() -1; i++){
 *             expendCenter(s, i, i);
 *             expendCenter(s, i, i+1);
 *         }
 *         return s.substring(start, start + max);
 *     }
 *
 *     public void expendCenter(String s, int i, int j){
 *         while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
 *             i--;
 *             j++;
 *         }
 *         if(max < j - i - 1){ //j - 1 - i - 1 + 1
 *             max = j - i - 1;
 *             start = i + 1;
 *         }
 *     }
 */

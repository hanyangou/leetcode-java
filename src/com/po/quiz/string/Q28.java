package com.po.quiz.string;

/***
 * time complexity: O((H-N)N) where H = haystack.length(), N = needle.length()
 * space: O(1)
 */
public class Q28 {
    public int strStr(String haystack, String needle) {
        if((haystack == null || haystack.length() == 0) && (needle == null || needle.length() == 0)) return 0;
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;

        for(int i = 0 ; i < haystack.length() - needle.length() + 1 ; i++){
            int idx = 0;
            int j = i;
            boolean found = true;
            while (idx < needle.length()){
                if(needle.charAt(idx) != haystack.charAt(j)) {
                    found = false;
                    break;
                }

                idx++;
                j++;
            }
            if(found)
                return i;
        }
        return -1;
    }
}

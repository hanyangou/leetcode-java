package com.po.quiz.binarysearch;

public abstract class Q278 {
    // g g b b b
    // g g g b
    // g g g g b b
    // g g g g g g b
    // g b b b b b b
    // g b
    // b
    // g g g g
    public int firstBadVersion(int n) {
        if(n == 1) return n;
        int left = 1, right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            //terminate base : isBadVersion(mid) == true && isBadVersion(mid+1) == false
            //caching the result from api ca n minimize the call to api
            //be careful about the boundary
            boolean isMidBad = isBadVersion(mid);
            if(!isMidBad && isBadVersion(mid + 1)) return mid + 1;
            if(!isMidBad){ //check if later version
                left = mid + 1;
            } else { //check previous version
                right = mid;
            }
        }
        return left;
    }

    abstract boolean isBadVersion(int version);
}

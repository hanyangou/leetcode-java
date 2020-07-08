package com.po.quiz.dp;

public class Q55 {
    enum Mark {
        GOOD, BAD, UNKNOWN
    }

    Mark[] memo;
    public boolean canJump(int[] nums) {
        return dp(nums);
    }

    //dp - bottom up approach
    private boolean dp(int[] nums){
        memo = new Mark[nums.length];
        for(int i = 0; i < nums.length; i++) {memo[i] = Mark.UNKNOWN;}

        memo[nums.length - 1] = Mark.GOOD;
        for(int i = nums.length - 2; i >= 0; i--){
            int farestJump = Math.min(i + nums[i], nums.length - 1);
            for(int j = i + 1; j <= farestJump; j++){
                if(memo[j].equals(Mark.GOOD)){
                    memo[i] = Mark.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Mark.GOOD;
    }
    //backtracking
    //try every step that is reachable
    //if stuck, backtrack to previous step
    private boolean backtracking(int[] nums){
        //corner case
        if(nums == null || nums.length == 0) return false;
        if(nums.length == 1) return true;
        return backtracking(nums, 0);
    }

    private boolean backtracking(int[] nums, int pos){
        int steps = nums[pos];
        if(steps == 0) return false;
        for(int i = 1; i <= steps; i++){
            int nextPos = pos + i;
            if(nextPos == nums.length - 1) return true;
            if(backtracking(nums, pos + i)) return true;
        }
        return false;
    }
}

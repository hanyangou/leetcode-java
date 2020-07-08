package com.po.quiz.dp;

public class Q416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 == 1) return false;

        sum /= sum /2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        for(int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for(int j = 1; j <= sum; j++) dp[0][j] = false;
        for(int i = 1; i < nums.length; i++){
            for(int j = 1; i <= sum; j++){
                if(j >= nums[i - 1]){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}

package com.po.quiz.dp;

/***
 * we either plus this item or minus this item to get sum for first i items
 * we store total ways to make to amount from i items in dp[item][sum]
 */
public class Q494 {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length + 1][S + 1];
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= S; j++){
                if(j == nums[i-1])
                    dp[i][j] = dp[i][j] + dp[i-1][j - nums[i-1]] + 1;
                else if (j == -nums[i-1])
                    dp[i][j] = dp[i][j] + dp[i-1][j + nums[i+1]] + 1;
            }
        }
        return dp[nums.length][S];
    }
}

package com.po.quiz.dp;

/***
 * calculating the amount from 1 to amount and memorize the number of combination for that amount
 * the new amount = count[amount - coin[i]] + 1
 *
 *  dp[i][j] = d[i-1][j] || dp[i-1][j - coins[i]]
 */
public class Q518 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; i <= amount; j++){
                if(j >= coins[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i][i - coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}

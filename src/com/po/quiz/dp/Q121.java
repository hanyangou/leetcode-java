package com.po.quiz.dp;

public class Q121 {
    public int maxProfit(int[] prices) {
        //Input: [7,1,5,3,6,4]
        int max = 0;
        int[] dp = new int[prices.length];
        for(int i = 1; i < prices.length; i++){
            int profit = dp[i-1] + prices[i] - prices[i-1];
            if(profit > 0){
                dp[i] = profit;
                max = Math.max(profit, max);
            }
        }
        return max;
    }
}

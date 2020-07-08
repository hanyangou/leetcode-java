package com.po.quiz.dp;

public class Q322 {
    public int coinChange(int[] coins, int amount) {
        int[] counts = new int[amount + 1];
        counts[0] = 0;
        return backtrack(coins, amount, counts);
    }

    public int backtrack(int[] coins, int amount, int[] counts){
        if(amount < 0) return -1;
        if(counts[amount] != 0) return counts[amount];
        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            int res = backtrack(coins, amount - coin, counts);
            if(res >= 0 && res < min){
                res += 1;
                counts[amount] = res;
            }
        }
        return counts[amount] ;
    }

}

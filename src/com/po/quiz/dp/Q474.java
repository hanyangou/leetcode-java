package com.po.quiz.dp;

public class Q474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] res = new int[l + 1][m + 1][n + 1];
        for(int i = 1; i <= l; i++){
            for(int j = 1; j <= m; j++){
                for(int k = 1; k <= n; k++){
                    int[] nums = getZeroAndOne(strs[i-1]);
                    if(j >= nums[0] && k >= nums[1]){
                        res[i][j][k] = Math.max(res[i-1][j][k],res[i-1][j-nums[0]][k-nums[1]] + 1);
                    } else {
                        res[i][j][k] = res[i-1][j][k];
                    }
                }
            }
        }
        return res[l][m][n];
    }

    public int[] getZeroAndOne(String str){
        int[] counts = new int[2];
        for(char c : str.toCharArray()){
            if(c == '0') counts[0] = counts[0] + 1;
            if(c == '1') counts[1] = counts[1] + 1;
        }
        return counts;
    }
}

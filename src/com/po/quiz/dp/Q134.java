package com.po.quiz.dp;

public class Q134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        //find the possible start pt
        //if gas[start] - cost[start] < 0, impossible to be start point
        //
        int start;
        int len = gas.length;
        for(start = 0; start < len; start++){
            int total = 0;
            boolean canComplete = true;
            for(int cur = start; cur < start + len; cur++){
                int pos = cur % len;
                total += gas[pos] - cost[pos];
                if(total < 0){
                    canComplete = false;
                    break;
                }
            }
            if(canComplete) return start;
        }
        return -1;
    }
}

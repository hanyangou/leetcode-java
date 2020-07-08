package com.po.quiz.backtrack;

import java.util.*;

/***
 * constrain: sum <= target. no duplicate combination
 * termination condition: sum == target
 *
 * 1. check if next int holds constraint
 * 2. if it does, place it in the tmp result
 * 3. backtrack with next candidate
 * 4. remove last candidate from tmp result
 */
public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //corner base
        Set<List<Integer>> res = new HashSet<>();
        backtrack(res, new ArrayList<>(), candidates, 0, target);
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }

    public void backtrack(Set<List<Integer>> res, List<Integer> tmp, int[] candidates, int sum, int target){
        //termination
        if(sum == target){
            ArrayList<Integer> copy = new ArrayList<>(tmp);
            Collections.sort(copy);
            res.add(copy);
            return;
        }
        //otherwise run backtracking steps
        for(int i = 0; i < candidates.length; i++){
            if(candidates[i] + sum > target) continue;

            //place
            tmp.add(candidates[i]);
            sum += candidates[i];

            //backtrack
            backtrack(res, tmp, candidates, sum, target);
            //remove
            sum -= candidates[i];
            tmp.remove(tmp.size()-1);
        }
        return;
    }
}

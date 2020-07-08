package com.po.quiz.backtrack;

import java.util.*;

/***
 * All numbers (including target) will be positive integers. -> no zero and negative.
 * The solution set must not contain duplicate combinations. -> using Set first to filter out duplication
 *
 * finding all combination: backtracking
 */
public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < candidates.length; i++){
            backtrack(candidates, target, i, 0, new ArrayList<>(), res);
        }

        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int idx, int sum, List<Integer> tmp, Set<List<Integer>> res){
        //terminate
        if(sum == target){ //only positive, so we can end the backtrack once we found the combo
            List<Integer> toAdd = new ArrayList<>(tmp);
            Collections.sort(toAdd);
            res.add(toAdd);
            return;
        }
        if(idx >= candidates.length) return;
        //if(idx > candidates.length - 1) return; //out of boundary
        //place
        int candidate = candidates[idx];
        tmp.add(candidate);
        //track
        for(int i = idx + 1; i <= candidates.length; i++){
            backtrack(candidates, target, i, sum + candidate, tmp, res);
        }
        //remove
        tmp.remove(tmp.size() - 1);
    }
}

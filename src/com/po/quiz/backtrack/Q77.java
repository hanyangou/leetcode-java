package com.po.quiz.backtrack;

import java.util.ArrayList;
import java.util.List;

/***
 * constraint: length == 2 and digit is 1-n
 */
public class Q77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k == 0) return res;
        backtrack(res, new ArrayList<>(), 1, n ,k);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int start, int n, int k){
        if(tmp.size() == k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start; i <= n; i++){
            tmp.add(i);
            backtrack(res, tmp, i + 1, n, k);
            tmp.remove(tmp.size() - 1);
        }

        return;
    }
}

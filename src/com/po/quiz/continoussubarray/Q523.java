package com.po.quiz.continoussubarray;

import java.util.HashMap;
import java.util.Map;

/***
 * cumulative sum - desire value K exists if arr[i] - arr[j] = K, arr[i] is cumulative sum from 0 - i and arr[j] is cumulative sum from
 * 0 - j.
 *
 * this question is asking the multiple of Y, which equals to X % Y = 0. with cumulative sum, we can find that array from i+1 to j
 * when (arr[j] - arr[i]) % Y = 0 --> arr[j] % Y = arr[i] % Y
 */
public class Q523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(k == 0){
                if(sum == 0) return true;
                if(map.containsKey(sum)){
                    if(i - map.get(sum) > 1) return true;
                } else {
                    map.put(sum, i);
                }
            } else {
                sum = sum % k;
                if(map.containsKey(sum)){
                    if(i - map.get(sum) > 1) return true;
                } else {
                    map.put(sum, i);
                }
            }
        }
        return false;
    }
}


/***
 HashMap<Integer, Integer> map = new HashMap<>(); //<sum % k, pos>
 map.put(0, -1);
 int sum = 0;
 for(int i = 0; i < nums.length; i++){
 sum += nums[i];
 if(k != 0) sum = sum % k;
 if(map.containsKey(sum)){
 if(i - map.get(sum) > 1) return true;
 } else {
 map.put(sum, i);
 }
 }
 return false;
***/
package com.po.quiz.continoussubarray;

/***
 * culumative sum
 * hash map with occrance of sum
 */
public class Q560 {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length];
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sums[i] = sum;
            if(sums[i] == k) res++;
        }
        for(int i = 0; i < sums.length - 1; i++){
            for(int j = 1; j < sums.length; j++){
                if(sums[j] - sums[i] == k) res++;
            }
        }
        return res;
    }
}

/***
 public int subarraySum(int[] nums, int k) {
 HashMap<Integer, Integer> map = new HashMap<>();
 int sum = 0, count = 0;
 map.put(0, 1);
 for(int i = 0; i < nums.length; i++){
 sum += nums[i];
 if(map.containsKey(sum - k)){
 count += map.get(sum - k);
 }
 map.put(sum, map.getOrDefault(sum, 0) + 1);
 }
 return count;
 }
***/
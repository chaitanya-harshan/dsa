package arrays.medium;

import java.util.HashMap;

public class _14_subArrCount {
   public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int i=0; i< nums.length; i++) {
            sum += nums[i];
            if (sum == k) count++;
            if (i != 0 && map.containsKey(sum-k)) count += map.get(sum-k);
            if (map.containsKey(sum)){
                int freq = map.get(sum);
                map.put(sum, ++freq);
            }
            else map.put(sum, 1);
        }
        return count;
    }
}

/*
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * 
 * Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */
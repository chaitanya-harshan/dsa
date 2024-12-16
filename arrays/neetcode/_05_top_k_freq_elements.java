package arrays.neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _05_top_k_freq_elements {
    
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List<Integer>[] freq = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            freq[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer,Integer> val: map.entrySet()) {
            freq[ val.getValue() ].add(val.getKey());
        }

        int[] res = new int[k];
        int idx = 0; // result index
        for (int i = n; i > 0; i--) {
            if (freq[i].isEmpty()) continue;

            for (int num: freq[i]) {
                if (idx < k) res[idx++] = num;
                else break;
            }
            if (idx >= k) break;
        }

        return res;

        // -----Using Priority Queue-----
        // HashMap<Integer, Integer> map = new HashMap<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        // for (int i: nums) map.put(i, map.getOrDefault(i,0)+1);

        // for (int i: map.keySet()) {
        //     pq.offer(i);
        // }

        // int[] res = new int[k];
        // for (int i=0; i<k; i++) {
        //     res[i] = pq.poll();
        // }
        // return res;
    }
}
// *************************************************
// nums[] = 1,1,5,1,2,5,2,100

// idx/ - 0 1     2    3  4 5 6
// cnt    _____________________
//        [100] [2,5] [1]
// *******************************************************



/*
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * 
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 */
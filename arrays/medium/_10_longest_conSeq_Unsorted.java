package arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class _10_longest_conSeq_Unsorted {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> map = new HashSet<>();
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i<nums.length; i++) {
            map.add(nums[i]);
        }

        for (int key: map) {
            if (!map.contains(key-1)) {
                count = 1;
                int i = 1;
                while (map.contains(key+i)) {
                    count++;
                    i++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}

/*
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */
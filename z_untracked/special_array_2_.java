package z_untracked;

public class special_array_2_ {
    
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] parity = new int[n];
        parity[0] = 0;
        int flag = 0;

        for (int i=1; i<n; i++) {
            if (nums[i-1]%2 == nums[i]%2) flag++;
            parity[i] = flag;
        }

        boolean[] res = new boolean[queries.length];
        for (int i=0; i<queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (parity[left] == parity[right]) res[i] = true;
            else res[i] = false;
        }

        return res;
    }
}

/*
 * 3152. Special Array II
 * https://leetcode.com/problems/special-array-ii/description/
 * 
An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that 
subarray
 nums[fromi..toi] is special or not.

Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.

 

Example 1:

Input: nums = [3,4,1,2,6], queries = [[0,4]]

Output: [false]

Explanation:

The subarray is [3,4,1,2,6]. 2 and 6 are both even.

Example 2:

Input: nums = [4,3,1,6], queries = [[0,2],[2,3]]

Output: [false,true]

Explanation:

The subarray is [4,3,1]. 3 and 1 are both odd. So the answer to this query is false.
The subarray is [1,6]. There is only one pair: (1,6) and it contains numbers with different parity. So the answer to this query is true.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= queries.length <= 105
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] <= nums.length - 1
 */
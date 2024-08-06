// https://leetcode.com/problems/house-robber/


//    last current   2, 7, 9, 3, 1
//     [0      0]    2                -> 2+0 > 0
//                     7              (cause 7 > 2)
//                         11         -> 9+2 > 7
//                             11     -> 11 > 7+3
//                               12   -> 11+1 > 1

//                     2 7 11 11 12


public class _03_house_robber_1 {
    
    public int rob(int[] nums) {
        // if (nums.length == 1) return nums[0];
        // if (nums.length == 2) return Math.max(nums[0], nums[1]);
        // int last = nums[0];
        // int current = Math.max(last, nums[1]);

        int last = 0, current = 0;
        for (int i = 0; i<nums.length; i++) {
            int temp = current;
            current = Math.max(nums[i] + last, temp);
            last = temp;
        }
        return current;
    }
}

/*
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have security systems 
 * connected and it will automatically contact the police if two adjacent houses were broken
 * into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.
 */
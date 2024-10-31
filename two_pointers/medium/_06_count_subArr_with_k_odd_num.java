package two_pointers.medium;

public class _06_count_subArr_with_k_odd_num {

    // ### 3 Pointer
    // public int numberOfSubarrays(int[] nums, int k) {
    //     int l = 0, m = 0;
    //     int cnt = 0, odd = 0;

    //     for (int r=0; r<nums.length; r++) {
    //         odd += nums[r] % 2;

    //         while (odd > k) {
    //             odd -= nums[l] % 2;
    //             l++;
    //             m = l;
    //         }

    //         if (odd == k) {
    //             while (nums[m] % 2 != 1) {
    //                 m++;
    //             }
    //             cnt += m-l+1;
    //         }
    //     }
    //     return cnt;
    // }

    public int numberOfSubarrays(int[] nums, int k) {
        return subarrLessOrEq(nums, k) - subarrLessOrEq(nums, k-1);
    }
    static int subarrLessOrEq(int[] nums, int k) {
        // 1 <= k <= ...
        int l = 0;
        int cnt = 0, odd = 0;

        for (int r = 0; r<nums.length; r++) {
            odd += nums[r] % 2;

            while (odd > k) {
                odd -= nums[l] % 2;
                l++;
            }

            cnt += r-l+1;
        }
        return cnt;
    }
}

/*
https://leetcode.com/problems/count-number-of-nice-subarrays/description/ 
 * 1248. Count Number of Nice Subarrays
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
 */
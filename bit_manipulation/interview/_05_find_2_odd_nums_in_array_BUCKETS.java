// super tough because it needs a algorithm
/*
 * 1. we need to find the diff_bit by xor which tells us that it's because of 
 * those single numbers having a 1 and 0.
 * we need to seperate the single numbers into 2 buckets using the logic that 
 */
package bit_manipulation.interview;

public class _05_find_2_odd_nums_in_array_BUCKETS {
    
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i; // finally contains the xor of the 2 single nums which in bits gives the bits where both have diff bits in that idx
        }
        int diff_bit = (xor & xor-1) ^ xor;
        // xor      110100
        // xor-1    110011
        // &        110000

        // xor      110100
        // & ^ xor  000100 --> diff_bit(1st one)
        // we'll use this diff_bit to seperate the 2 single nums into diff buckets. rest of the nums we dont care as they all get cancelled on xor as same nums get have same bits and they get into the same buckets

        int a = 0, b=0;
        for (int num : nums) {
            if ((num & diff_bit) == diff_bit) a ^= num;
            else b ^= num;
        }

        return new int[]{a,b};
    }
}

/*
https://leetcode.com/problems/single-number-iii/description/

 * 260. Single Number III
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
 */
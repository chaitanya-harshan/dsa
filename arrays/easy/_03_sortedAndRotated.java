package arrays.easy;

// Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
public class _03_sortedAndRotated {
    public boolean check(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                flag++;
                if (flag > 1 ) return false;
            }
            if (flag != 0 && nums[i+1] > nums[0]) return false;
        }
        return true;
    }
}

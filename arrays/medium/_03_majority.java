package arrays.medium;

public class _03_majority {
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (count == 0) {
                element = nums[i];
                count = 1;
            }
            else if (nums[i] == element) {
                count++;
            }
            else count--;
        }
        // Not needed as it's mentioned that there exists a majority element

        // int counter = 0;
        // for (int i=0; i<nums.length; i++) {
        //     if (nums[i] == element) counter++;
        // }
        // if (counter > nums.length/2) return element;

        // return -1;

        return element;
    }
}

/*
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
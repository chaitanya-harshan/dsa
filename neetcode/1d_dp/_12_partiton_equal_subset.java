/*
 * 416. Partition Equal Subset Sum
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */
import java.util.Arrays;
import java.util.HashSet;

public class _12_partiton_equal_subset {
    public static void main(String[] args) {
        // System.out.println(canPartition(new int[]{1,5,11,5}));
        System.out.println(canPartition(new int[]{1,2,5}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum/2;
        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = nums.length-1; i >= 0; i--) {
            HashSet<Integer> tempDP = new HashSet<>(dp); // you can't iterate through a set & add elements to the set at the same time 
            for (int val : tempDP) {
                if (nums[i] + val == target) return true;
                dp.add(nums[i] + val);
            }
        }
        return false;
    }
}


// https://www.youtube.com/watch?v=IsvocB5BJhw it's weird (neetcode)

/*
 * sum/2 = target as if the subsets are equal then both subsets have equal sum
 * iterating from the end from nums
 * adding nums[i] + set_values to the set 
 * and then again for the next nums[i] iterating through the set and adding the nums[i] + set_values to the set
 *   
 * 0
 * 0,5
 * 0,5,11,16         we will get the ans here which is 11 but lets keep on going for explantions
 * 0,5,  _,11,16,   _,10, _,21
 * 0,5,  _,11,16,   _,10, _,21,     _,_, 12,17, _,22 
 */
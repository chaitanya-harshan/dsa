package arrays.easy;

import java.util.Arrays;

public class removeDuplicates_sorted {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,5,6,6,7,7};
        removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j<nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }


    // better code is in leetcode and striver 
    // it's much simplier then this         https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
    static int removeDuplicates1(int[] nums) {
        int correction = 0;
        for (int i = 1; i<nums.length; i++) {
            int check = nums[i-1];
            while (check == nums[i] && i<nums.length-1) {
                correction++;
                i++;
            }
            if (check == nums[i] && i == nums.length-1) correction++;
            nums[i-correction] = nums[i];
        }
        return nums.length - correction;
    }
}
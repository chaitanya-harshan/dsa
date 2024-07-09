package arrays.medium;

import java.util.Arrays;

public class _08_next_Lexographic_permutation {
    public static void main(String[] args) {
        int[] arr = {1,3,2};

        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        for (int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums,0);
            return;
        }

        for (int i = n-1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, index, i);
                break;
            }
        } 
        reverse(nums, index+1);
    }

    static void reverse(int[] nums, int idx) {
        int n = nums.length-1;
        for (int i = idx; i < n; i++,n--) {
            swap(nums, i, n);
        }
    }

    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

/*
 * Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).

Input format:
 Arr[] = {1,3,2}
Output
: Arr[] = {2,1,3}
Explanation: 
All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.
 */
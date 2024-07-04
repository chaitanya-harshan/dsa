package arrays.medium;

import java.util.Arrays;

public class nextLexographic {
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

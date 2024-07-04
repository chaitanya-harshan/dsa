package arrays.easy;

// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
public class rotate {
    public void rotateArray(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = (low + high)/2;
        while(low <= mid) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}

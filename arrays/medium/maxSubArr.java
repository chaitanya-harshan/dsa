// Given an integer array arr, find the contiguous subarray (containing at least one number) which
// has the largest sum and returns its sum and prints the subarray.

package arrays.medium;

public class maxSubArr {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int low = 0, high = 1;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) low = i;

            sum += nums[i];

            if (sum > max) {
                max = sum;
                high = i;
            }
            if (sum < 0) sum = 0;
        }
        for (int i = low; i <= high; i++) {
            System.out.print(nums[i]+" ");
        }
        return max;
    }
}

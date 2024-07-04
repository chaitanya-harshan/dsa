package binary.math;

public class _10_split_arr_largest_sum {
    public static int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for(int i = 0; i<nums.length; i++){
            max = Math.max(max,nums[i]);
            sum += nums[i];
        }

        int low = max, high = sum;
        while (low <= high){
            int mid = (low + high)/2;
            if (subArrays(nums, mid) <= k) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    static int subArrays(int[] nums, int limit) {
        int count = 1, sum = nums[0];
        for(int i = 1;i<nums.length; i++){
            if (sum + nums[i] <= limit) {
                sum += nums[i];
            }
            else {
                count++;
                sum = nums[i];
            }
        }
        return count;
    }
}

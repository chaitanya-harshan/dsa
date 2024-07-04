package binary.math;

public class _05_smallest_divisor {
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = max(nums);

        while (low <= high) {
            int mid = (low+high)/2;
            if (possible(nums, threshold, mid)) {
                high = mid -1;
            }
            else low = mid + 1;
        }
        return low;
    }

    static boolean possible(int[] nums, int k, int divisor) {
        int quotient = 0;
        for (int i=0; i<nums.length; i++) {
            quotient += Math.ceil((double)nums[i]/divisor);
        }
        return quotient <= k;
    }

    static int max(int[] nums) {
        int num = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            num = Math.max(num, nums[i]);
        }
        return num;
    }
}

package binary.math;

public class _06_smallest_shipCapacity {
    public static int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int totalWeight = 0;
        for (int i = 0; i<weights.length; i++) {
            max = Math.max(max, weights[i]);
            totalWeight += weights[i];
        }

        int low = max, high = totalWeight;
        while (low <= high) {
            int mid = (low + high)/2;
            if (possible(weights, days, mid)) {
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return low;
    }

    static boolean possible(int[] nums, int days, int limit) {
        int sum = 0, count = 0;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
            if (sum > limit){
                count++;
                sum = nums[i];
            }
        }
        count++;
        return count <= days;
    }
}

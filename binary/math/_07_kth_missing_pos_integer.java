package binary.math;

public class _07_kth_missing_pos_integer {
    
    public static int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = (low + high)/2;
            int missing = arr[mid] - mid-1;
            if(missing < k) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        // arr[high] + (k - missing)
        // arr[high] +   k-(arr[high] - (high +1)) 
        return k + high + 1;
        // return low + k;
    }
}

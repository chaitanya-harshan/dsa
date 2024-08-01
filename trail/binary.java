public class binary {
    
    public static boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high)/2;

        while (low <= high) {
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}

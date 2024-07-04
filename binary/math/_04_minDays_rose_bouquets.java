package binary.math;

public class _04_minDays_rose_bouquets {

    public static void main(String[] args) {
        int[] arr = {1,10,3,10,2};
    System.out.println(minDays(arr, 3,4));
    }
      
    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long)m*k) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i<bloomDay.length; i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        while (low <= high) {
            int mid = (low+high)/2;
            if (possible(bloomDay, m, k, mid)) {
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return low;
    }

    static boolean possible(int[] arr, int m, int k, int days) {
        int bouquets = 0;
        int roses = 0;
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] <= days) {
                roses++;
            }
            else {
                bouquets += roses/k;
                roses = 0;
            }
        }
        bouquets += roses/k;
        return bouquets >= m;
    }
}


package binary.math;

import java.util.Arrays;

public class _08_angry_cows {
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println(ans);
    }

    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length-1] - stalls[0];
        while (low <= high) {
            int mid = (low + high)/2;
            if (canWePlace(stalls,k,mid)) {
                low = mid + 1;
            }
            else high = mid -1;
        }
        return high;
    }

    static boolean canWePlace(int[] arr, int cows, int diff) {
        int last = arr[0];
        int count = 1;
        for (int i = 1; i<arr.length; i++) {
            if (arr[i] - last >= diff){
                count++;
                last = arr[i];
            }
            if (count >= cows) return true;
        }
        return false;
    }
}

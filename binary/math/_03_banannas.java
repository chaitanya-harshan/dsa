/* 
* Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
    The guards have gone and will come back in h hours.
    Koko can decide her bananas-per-hour eating speed of k.
* Each hour, she chooses some pile of bananas and eats k bananas from that pile.
    If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
* Return the minimum integer k such that she can eat all the bananas within h hours.

*/

package binary.math;


public class _03_banannas {

    public static void main(String[] args) {
        int arr[] = {3,6,7,11};
        System.out.println(minEatingSpeed(arr, 8));
    }

    
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = max(piles);

        while (low <= high) {
            int mid = (low + high)/2;
            int time = calculateTime(piles, mid);
            if (time <= h) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    static int calculateTime(int[] piles ,int k) {
        int time = 0;
        for (int i = 0; i<piles.length; i++) {
            time += Math.ceil((double)piles[i] / k);
        }
        return time;
    }

    static int max(int[] arr) {
        int max = 0;
        for (int i = 0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
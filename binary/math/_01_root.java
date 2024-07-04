package binary.math;

/**
 * _01_root
 */
public class _01_root {

    
    long floorSqrt(long x) {
       // Your code here
       long ans = 1;
       long low = 0, high = x/2+1;
       while (low <= high) {
           long mid = (low + high)/2;
           if (mid*mid <= x) {
               ans = Math.max(ans,mid);
               low = mid + 1;
           }
           else high = mid - 1;
       }
       return ans;
    }
}
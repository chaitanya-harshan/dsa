package binary.math;

public class _14_Kth_element_combined_sorted_arrays {
    public static void main(String[] args) {
        // int[] a = {1, 4, 7, 10, 12};
        // int[] b = {2, 3, 6, 15};
        int[] a = {5, 5, 8, 8, 8, 9, 11, 11, 11, 11, 11};
        int[] b = {4, 4, 4, 4, 6, 8, 9, 9, 9, 11, 13,};
        System.out.println("The kth element is " + kthElement(a, b, a.length, b.length, 2));
    }

    public static long kthElement( int a[], int b[], int m, int n, int k) {
        if (m > n) return kthElement(b, a, n, m, k);
        
        int left = k;
        int low = Math.max(0,k-n);// can't use math.abs it will result in always low>high
        int high = Math.min(k,m);
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            int r1 = (mid1 < m) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;
            int l1 = (mid1-1 >= 0) ? a[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2-1 >= 0) ? b[mid2-1] : Integer.MIN_VALUE;
            
            
            if (l1 <= r2 && l2 <= r1) {
                return (long)Math.max(l1,l2);
            }
            else if (l1 > r2) high = mid1-1;
            else low = mid1+1;
        }
        return 0;
    }
}

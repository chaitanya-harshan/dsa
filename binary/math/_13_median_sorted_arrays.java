package binary.math;

public class _13_median_sorted_arrays {


    // OPTIMAL VERSION--------------------
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        if (n1 > n2) return findMedianSortedArrays(b,a);

        int left = (n1 + n2 +1)/2; // length of the left half

        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low +high)/2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n1) r1 = a[mid1];
            if (mid2 < n2) r2 = b[mid2];
            if (mid1-1 >= 0) l1 = a[mid1-1];
            if (mid2-1 >= 0) l2 = b[mid2-1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1,l2);
                else return ( (double)Math.max(l1,l2) + Math.min(r1,r2) )/2.0;
            }
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }

    // BETTER version---------------------------------------------------
    public double findMedianSortedArrays1(int[] a, int[] b) {
        int length = a.length + b.length;
        int id2 = length / 2;
        int id1 = id2 - 1;
        int count = 0;
        int e1 = -1, e2 = -1;

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (count == id1) e1 = a[i];
                else if (count == id2) {
                    e2 = a[i];
                    count++;
                    break;
                }
                i++;
                count++;
            }
            else {
                if (count == id1) e1 = b[j];
                else if (count == id2) {
                    e2 = b[j];
                    count++;
                    break;
                }
                j++;
                count++;
            }
        }
        while (i < a.length) {
            if (count == id1) e1 = a[i];
            else if (count == id2) {
                e2 = a[i];
                break;
            }
            i++;
            count++;
        }
        while (j < b.length) {
            if (count == id1) e1 = b[j];
            else if (count == id2) {
                e2 = b[j];
                break;
            }
            j++;
            count++;
        }

        if (length % 2 == 0) return ((double)e1+e2)/2.0;
        else return (double)e2; 
    }
}

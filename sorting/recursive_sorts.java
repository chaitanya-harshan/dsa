package sorting;
import java.util.Arrays;

public class recursive_sorts {
    public static void main(String[] args) {
        int[] arr = {3,5,7,24,74,3,5,6,23,9};
        recursive_bubble_sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        recursive_insertion_sort(arr, 1, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void recursive_bubble_sort(int[] arr, int n) {
        if (n == 1) return;

        for (int i = 0; i < n-1; i++) {
            if (arr[i] > arr[i+1]) {
                // swap
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        recursive_bubble_sort(arr, n-1);
    }

    static void recursive_insertion_sort( int[] arr, int index, int n) {
        if ( index == n ) return;
        // int j = i;
        // while (j > 0 && arr[j] < arr[j-1]) {
        //     int temp = arr[j-1];
        //     arr[j-1] = arr[j];
        //     arr[j] = temp;
        //     j--;
        // }
        for (int i = index; (i>0 && arr[i]< arr[i-1]); i--) {
            int temp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = temp;
        }
        recursive_insertion_sort(arr, index+1, n);
    }
}

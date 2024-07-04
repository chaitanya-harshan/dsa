package sorting;
import java.util.Arrays;
public class basic_sorts {

    public static void main(String[] args) {
        int[] arr = {3,5,7,24,74,3,5,6,23,9};
        insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selection_sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    static void bubble_sort(int[] arr) {
        int n = arr.length;
        // boolean did_swap_happen = false; --- to make O(N) for best case (already sorted)
        for (int i = n; i > 1; i--) {
            for (int j = 0; j < i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // did_swap_happen = true; ---
                }
            }
            // if (!did_swap_happen) break; ---
        }
    }

    static void insertion_sort( int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // int j = i;
            // while (j > 0 && arr[j] < arr[j-1]) {
            //     int temp = arr[j-1];
            //     arr[j-1] = arr[j];
            //     arr[j] = temp;
            //     j--;
            // }
            for (int j = i; (j>0 && arr[j]< arr[j-1]); j--) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
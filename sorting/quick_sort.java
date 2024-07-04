package sorting;

import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args) {
        int[] arr = {4,6,2,5,7,9,1,3};
        quick_sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quick_sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partion( arr, low, high);
            quick_sort(arr, low, pivot-1);
            quick_sort(arr, pivot+1, high);
        }
    }

    static int partion(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i<j) {
            while (arr[i] <= pivot && i < high) i++;
            while (arr[j] > pivot && j > low) j--;

            if (i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
}

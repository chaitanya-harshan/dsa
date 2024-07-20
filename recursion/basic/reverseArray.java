package recursion.basic;

import java.util.Arrays;

public class reverseArray {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int length = arr.length;
        reverseArray(arr, 0, length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArray(arr, start+1, end-1);
        // since it's void u dont need to return for it to retun to function call. 
    }
}


//    -------------USING LIBRARY FUNCTIONS-----------

// import java.util.Collections******************

//  public static void main(String[] args) {
//     int n = 5;
//     Integer arr[] = {5,4,3,2,1};*****************
//     reverseArray(arr);
//     printArray(arr, n);
//  }

// static void reverseArray(Integer arr[]) {

//     === //fetching array as list object
//     === //reversing the fetched object

//     Collections.reverse(Arrays.asList(arr));******************
//  }


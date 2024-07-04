/*
Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.
There are ‘m’ number of students, and the task is to allocate all the books to the students.

Allocate books in such a way that:
1. Each student gets at least one book.
2. Each book should be allocated to only one student.
3. Book allocation should be in a contiguous manner.

You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.

If the allocation of books is not possible, return -1.
 */

package binary.math;

import java.util.ArrayList;

/**
 * _09_allocate_books
 */
public class _09_allocate_books {

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if (n < m) return -1;

        int max = 0, sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            max = Math.max(max, arr.get(i));
            sum += arr.get(i);
        }

        int low = max;
        int high = sum;
        while (low <= high) {
            int mid = (low + high)/2;
            if (countStudents(arr,mid) <= m) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    static int countStudents(ArrayList<Integer> books, int capacity) {
        int count = 1;
        int pages = books.get(0);
        for (int i = 1; i < books.size(); i++) {
            if (books.get(i) + pages <= capacity) {
                pages += books.get(i);
            }
            else {
                count++;
                pages = books.get(i);
            }
        }
        return count;
    }
}
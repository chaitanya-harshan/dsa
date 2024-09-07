/*
 * 300. Longest Increasing Subsequence
Given an integer array nums, return the length of the longest strictly increasing subsequence

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Input: nums = [0,1,0,3,2,3]
Output: 4

Input: nums = [7,7,7,7,7,7,7]
Output: 1

https://youtu.be/cjWnW0hdF1Y -neetcode memoization
https://youtu.be/on2hvxBXJH4 - striver binary
 */

import java.util.ArrayList;
import java.util.Collections;

public class _11_longest_increasing_subseqeunce {
    
    // memoiazation - O(n^2)
    /*
     * checking from the last index. max length of the sequence if starts from that index and 
     * then move to the first index checking with all the indexes after the current index where the 
     * nums[] > nums[i]
     * have a maxLength to store the max value because max length need not be when you start form index 0
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n]; // LIS - Longest Increasing Subsequence
        
        int maxLength = 1;
        for (int i=n-1; i>=0; i--) {
            int max = 1;
            for (int j=i+1; j<n; j++) {
                if (nums[i] < nums[j]) {
                    max = Math.max(max, 1 + LIS[j]);
                }
            }
            LIS[i] = max;
            maxLength = Math.max(maxLength, LIS[i]);
        }
        return maxLength;
    }

    // Binary search - O(N log N)

    /*
     *          1 7 8 4 5 6 -1 9
     *          
     *          1 7 8          9            1 7 8 9                 
     *          1     4 5 6    9            1 4 5 6 9 
     *                      -1 9           -1 9       
     */
    //           1
    //           1 7
    //           1 7 8
    //           1 4 8
    //           1 4 5
    //           1 4 5 6
    //          -1 4 5 6     --> these are wrong but u dont care as u only need length
    //          -1 4 5 6 9   _^

    // if a new small num is found it wont effect the length untill the sequence startign from that small num
    // exceed the length variable thats why we replace the original number in the list with the small number 
    // without giving a damn about it.
    // now while adding these small nums int he OG sequemce if we find a bigger number than the OG seqeunce
    // then we will add it to the end of the list and incrase the length.
    // this means it's like we didnt even add or care about the small nums we emcpuntered before we found this big number.

    // it doesn't give you the sub sequence but it gives you the length becasue you replicated
    // the same space with the values

    public static int lengthOfLIS_binary(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int length = 0;

        for (int n : nums) {
            int i = Collections.binarySearch(list, n); // gives the lower bound 
            if (i < 0) i = -i - 1; // adding 1 to get the upper bound idx if !found as it will return -ve indx if not found

            if (i == list.size()) {
                list.add(n);
                length++;
            }
            else list.set(i, n);
        }
        return length; // return list.size();
    }
}

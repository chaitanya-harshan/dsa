/*
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

 

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
 */
package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * rearrangeBySIgn
 */
public class _07_rearrange_by_sign {

    public static void main(String[] args) {
        int[] arr = {1, 2, -4, -5, 3, 4,-3,-5,8,9,1};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }

    static int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            }
            else neg.add(nums[i]);
        }
        int p = pos.size(), n = neg.size();
        int extras = Math.abs(p-n);

        int length = p;
        if (p>n) length = n;

        int P_Idx = 0;
        int N_Idx = 1;
        for (int i = 0; i < length; i++) {
            nums[P_Idx] = pos.get(i);
            nums[N_Idx] = neg.get(i);
            P_Idx += 2;
            N_Idx += 2;
        }

        if (p > n) {
            for (int i = 0; i < extras; i++) {
                nums[P_Idx+i] = pos.get(n+i);
            }
        }
        else {
            for (int i = 0; i < extras; i++) {
                nums[N_Idx+i] = neg.get(p+i);
            }
        }
        return nums;
    } 



    // if equal number of +ve and -ve are there 

    // public int[] rearrangeArray(int[] nums) {
    //     int[] arr = new int[nums.length];
    //     int pos = 0, neg = 1;
    //     for (int i=0; i<nums.length; i++) {
    //         if(nums[i] > 0) {
    //             arr[pos] = nums[i];
    //             pos += 2;
    //         }
    //         else {
    //             arr[neg] = nums[i];
    //             neg += 2;
    //         }

    //     }
    //     return arr;
    // }
}




package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * rearrangeBySIgn
 */
public class rearrangeBySIgn {

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




package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * leaders
 */
public class leaders {

    public static void main(String[] args) {
        int[] arr = {16,17,4,3,5,2};
        printLeaders(arr);
    }

    static void printLeaders(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        int max = nums[n-1];
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] >= max) {
                max = nums[i];
                list.add(nums[i]);
            }
        }
        Collections.reverse(list);
        for(int num: list) 
            System.out.print(num +" ");
    }
}
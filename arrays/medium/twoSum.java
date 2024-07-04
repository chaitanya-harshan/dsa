package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSumIndexs(arr,9)));
        //-
        System.out.println(Arrays.toString(twoSumIndexs(new int[]{3,2,4} ,6)));
    }

    public static int[] twoSumIndexs(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] arr = new int[2];

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                arr[0] = i;
                arr[1] = map.get(target - nums[i]);
                break;
            }
            if (!map.containsKey(nums[i])) map.put(nums[i], i);
        }
        return arr;
    }
}

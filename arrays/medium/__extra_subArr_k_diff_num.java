package arrays.medium;

import java.util.HashMap;

public class __EXTRA_subArr_k_diff_num {
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        return greatOrEqual(nums, k) - greatOrEqual(nums, k+1);
    }

    public static int greatOrEqual(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        if (n < k) return 0;
        
        int count = 0;
        int j = 0;
        for (int left = 0; left < n; left++) {
            while (j < n && map.size() < k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            if (map.size() == k) count += n-j+1;

            map.put(nums[left], map.get(nums[left])-1);
            if (map.get(nums[left]) == 0) map.remove(nums[left]);           
        }
        return count;
    }
}

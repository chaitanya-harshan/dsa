package arrays.medium;

import java.util.HashMap;

public class subArrCount {
   public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int i=0; i< nums.length; i++) {
            sum += nums[i];
            if (sum == k) count++;
            if (i != 0 && map.containsKey(sum-k)) count += map.get(sum-k);
            if (map.containsKey(sum)){
                int freq = map.get(sum);
                map.put(sum, ++freq);
            }
            else map.put(sum, 1);
        }
        return count;
    }
}

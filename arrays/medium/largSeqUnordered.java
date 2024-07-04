package arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class largSeqUnordered {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> map = new HashSet<>();
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i<nums.length; i++) {
            map.add(nums[i]);
        }

        for (int key: map) {
            if (!map.contains(key-1)) {
                count = 1;
                int i = 1;
                while (map.contains(key+i)) {
                    count++;
                    i++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}

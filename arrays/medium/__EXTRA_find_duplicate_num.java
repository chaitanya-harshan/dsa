package arrays.medium;

public class __EXTRA_find_duplicate_num {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,4,8,7};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (nums[slow] != nums[fast]);
        
        slow = 0;
        while (nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }

    // wont work when there are more than 2 number of the duplicate number like {2,3,4,3,3}
    public static int findDuplicate1(int[] nums) {
        int sum = 0;
        int sum_with_dup = 0;

        for(int i = 0; i<nums.length; i++) {
            if (i < nums.length-1) sum ^= i+1;
            sum_with_dup ^= nums[i];
        }
        return sum ^ sum_with_dup;
    }
}


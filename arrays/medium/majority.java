package arrays.medium;

public class majority {
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (count == 0) {
                element = nums[i];
                count = 1;
            }
            else if (nums[i] == element) {
                count++;
            }
            else count--;
        }
        // Not needed as it's mentioned that there exists a majority element

        // int counter = 0;
        // for (int i=0; i<nums.length; i++) {
        //     if (nums[i] == element) counter++;
        // }
        // if (counter > nums.length/2) return element;

        // return -1;

        return element;
    }
}

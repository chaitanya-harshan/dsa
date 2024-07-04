package arrays.medium;

import java.util.Arrays;

public class sort012s {
    public static void main(String[] args) {
        int[] arr = {0,1,2,1,0,2,1,0};
        colorSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void colorSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int i = 0;
        // you use while becasue poniter should stay at untill it finds a '1' or '0'.
        // If it keeps finding 2 it shoud stay there and swap
        // If else If else is needed so that for edge conditions like [.] [..] then only one of the if is executed 
        // which is needed incase when low goes out of bound or exceeds high.(if seperate If's are used)
        while (i <= high) {
            if (nums[i] == 2) {
                if (nums[high] != 2) {
                    int temp = nums[i];
                    nums[i] = nums[high];
                    nums[high] = temp;
                }
                high--;
            }
            else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[low];
                nums[low] = temp;
                low++;
                i++;
            }
            else if (nums[i] == 1) i++;
        }
    }
}

/*
 * 152. Maximum Product Subarray

Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
 */

// https://www.youtube.com/watch?v=hnswaLJvr6g - striver
// https://www.youtube.com/watch?v=Y6B-7ZctiW8  - some dude 
// first read the comments below 

public class _09_max_product_subarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-3,0,1,-2}));
        // System.out.println(maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0}));
    }

    // using double beacause of this Bitch ass test case which is even exceeding long for fuck sake!
    // [0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0]
    
    public static int maxProduct(int[] nums) {
        double prefix = 1;         // iterating from front
        double suffix = 1;         // iterating from end
        double max = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            // checking for '0' after i croses the index with '0' element => after prefix/suff becomes 0
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            // better dont bother about this code below
            // checking for '0' when i was at that index
            // if (nums[i] == 0) prefix = 1;
            // else prefix *= nums[i];
            // if (nums[n-1-i] == 0) suffix = 1;
            // else suffic *= nums[n-1-i];

            prefix *= nums[i];
            suffix *= nums[n-1-i];

            // checking IF prefix OR suffix > max
            max = Math.max(max, Math.max(prefix, suffix));

        }
        return (int)max;
    }
}

/*
you cannot have the ans in this way [* * * -*(* * * *) -* * *]
because you would just multiply the wholw thing as -* x -* = +ve and multiply the whole array.

Here,
4 -4 4 4 4 4 4 -4 4 -4 4
 we can do,
4 -4 4 4 4 4 4 -4 4 ||-4 4
        prefix        suffix
either prefix or suffix will always be the ans as even if there are more then 2 '-'
even number of -ve combine to form +ve leaving a single -ve which will act as the seperator '||' shown above

*/
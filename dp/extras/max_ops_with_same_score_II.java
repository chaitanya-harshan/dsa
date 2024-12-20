package dp.extras;

import java.util.HashSet;

public class max_ops_with_same_score_II {
    
    /*
     * Main Approach:
     * 1. First find all possible target sums using first/last pairs
     * 2. For each target sum, find max operations possible
     * 3. Return the maximum result among all target sums
     * 
     * Why these target sums?
     * - We must start with either first two elements, last two elements,
     *   or first and last elements
     * - One of these must be our first operation's sum
     * - All subsequent operations must match this sum
     */
    public int maxOperations(int[] nums) {
        int n = nums.length;
        HashSet<Integer> sumSet = new HashSet<>();
        sumSet.add(nums[0]+nums[1]);      // First two elements
        sumSet.add(nums[0]+nums[n-1]);    // First and last elements
        sumSet.add(nums[n-2]+nums[n-1]);  // Last two elements

        int res = 0;
        for (int target : sumSet) {
            // Try both recursive and DP approaches
            // res = Math.max(res, sameScoreOps(nums, 0, n-1, target));
            res = Math.max(res, sameScoreOps_dp(nums, target));
        }
        return res;
    }

    /*
     * Dynamic Programming Approach:
     * - State: dp[l][r] represents max operations possible in range [l,r]
     * - For each state, try three possible operations:
     *   1. Take first two elements
     *   2. Take first and last elements
     *   3. Take last two elements
     * 
     * Example: nums = [3,2,1,4,1,2], target = 5
     * - dp[0][5] represents entire array
     * - At each step, we try all three choices and take maximum
     * - Fill table bottom-up (smaller ranges to larger)
     * 
     * Time: O(n²), Space: O(n²)
     */
    public int sameScoreOps_dp(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int l = n-2; l >= 0; l--) {
            for (int r = l+1; r < n; r++) {
                // Choice 1: Take first two elements
                int f2 = 0;
                if (nums[l]+nums[l+1] == target && l+2 < n) 
                    f2 = 1 + dp[l+2][r];
                
                // Choice 2: Take first and last elements
                int fl = 0;
                if (nums[l]+nums[r] == target) 
                    fl = 1 + dp[l+1][r-1];
                
                // Choice 3: Take last two elements
                int l2 = 0;
                if (nums[r-1]+nums[r] == target && r-2 >= 0) 
                    l2 = 1 + dp[l][r-2];

                dp[l][r] = Math.max(f2, Math.max(fl, l2));
            }
        }
        return dp[0][n-1];
    }

    /*
     * Recursive Approach:
     * - For each state (l,r), try three possible operations
     * - Base case: when range becomes invalid (l >= r)
     * - For each valid operation:
     *   1. Add 1 to count current operation
     *   2. Recursively solve remaining subarray
     * 
     * Example: nums = [3,2,1,4,1,2], target = 5
     * Initial call (0,5):
     * └─ Can choose:
     *    1. First two (3+2=5) ✓
     *       └─ Recurse on [1,4,1,2]
     *    2. First-last (3+2=5) ✓
     *       └─ Recurse on [2,1,4,1]
     *    3. Last two (1+2=3) ✗
     * 
     * Time: O(3^n) without memoization
     * Space: O(n) recursion stack
     */
    public int sameScoreOps(int[] nums, int l, int r, int target) {
        if (l >= r) return 0;  // Base case: invalid range

        int firstTwo = 0;
        if (nums[l] + nums[l+1] == target) 
            firstTwo = 1 + sameScoreOps(nums, l+2, r, target);
        
        int firstLast = 0;
        if (nums[l] + nums[r] == target) 
            firstLast = 1 + sameScoreOps(nums, l+1, r-1, target);
        
        int lastTwo = 0;
        if (nums[r-1] + nums[r] == target) 
            lastTwo = 1 + sameScoreOps(nums, l, r-2, target);

        return Math.max(firstTwo, Math.max(firstLast, lastTwo));
    }
}


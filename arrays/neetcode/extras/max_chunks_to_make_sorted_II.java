package arrays.neetcode.extras;

public class max_chunks_to_make_sorted_II {
    
    /*
     * Thought Process:
     * 1. Key Insight: A chunk boundary exists at index i if:
     *    - max value in left part (0 to i) <= min value in right part (i+1 to end)
     *    - This ensures chunks can be sorted independently
     * 
     * 2. Solution Approach:
     *    - Create rightMin array to store minimum value from right side
     *    - Track leftMax while iterating
     *    - When leftMax <= rightMin[i+1], we can make a cut after index i
     * 
     * Example 1: arr = [5,4,3,2,1]
     * rightMin: [1,1,1,1,1,MAX]
     * leftMax at each step: [5,5,5,5,5]
     * Result: 1 chunk (no valid cuts possible)
     * 
     * Example 2: arr = [2,1,3,4,4]
     * rightMin: [1,1,3,4,4,MAX]
     * leftMax at each step: [2,2,3,4,4]
     * Chunks found at:
     * - After index 1: leftMax(2) <= rightMin(3) ✓
     * - After index 2: leftMax(3) <= rightMin(4) ✓
     * - After index 3: leftMax(4) <= rightMin(4) ✓
     * Result: 4 chunks [2,1] [3] [4] [4]
     * 
     * Time: O(n), Space: O(n)
     */
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE;
        
        // Build rightMin array - minimum value from right side
        for (int i = n-1; i>=0; i--) {
            rightMin[i] = Math.min(arr[i], rightMin[i+1]);
        } 

        // Count chunks using leftMax and rightMin comparison
        int chunks = 0;
        int leftMax = 0;
        for (int i=0; i<n; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            if (leftMax <= rightMin[i+1]) chunks++;
        }
        return chunks;
    }
}

/*
 * 768. Max Chunks To Make Sorted II
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 * 
 * Unlike Max Chunks To Make Sorted I:
 * - Array can have duplicates
 * - Numbers are not limited to 0 to n-1
 * - Still need to maximize number of chunks that can be sorted independently
 * 
You are given an integer array arr.
We split arr into some number of chunks (i.e., partitions), and individually 
sort each chunk. After concatenating them, the result should equal the sorted array.
Return the largest number of chunks we can make to sort the array.
 * 
 * Example: arr = [2,1,3,4,4]
 * Can be split into [2,1], [3], [4], [4]
 * After sorting each chunk: [1,2], [3], [4], [4]
 * Concatenating gives sorted array: [1,2,3,4,4]
 */


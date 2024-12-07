package dp.extras;

// https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
public class minimum_jumps_to_end {
    
    
    // ********* MINE -- Time limit exceeded 1100/1111 passed
    static int minJumps(int[] arr) {
        // code here
        final int LIMIT = 10_000_000;
        int n = arr.length;
        int[] jumps = new int[n];
        
        for (int i=n-1; i>=0; i--) {
            jumps[i] = LIMIT;
            if (arr[i] == 0) continue;
            
            if (arr[i] >= n-1-i) {
                jumps[i] = 1;
            }
            else {
                for (int j=1; j<=arr[i]; j++) {
                    jumps[i] = Math.min(jumps[i], jumps[i+j] + 1); // dont put jums[i+j] + 1 casue it'll be Int_MAX + 1
                }
            }
        }
        
        return jumps[0] >= LIMIT ? -1 : jumps[0];
    }


    // ************ NAGA SAI **********
    static int minJumps(int[] arr) {
        int n = arr.length;
        // your code here
        int jumps = 0;  // initialize the jump count
        int maxReach = 0;  // stores the maximum reachable index from the current position
        int steps = 0;  // stores the remaining steps at the current index

        for (int i = 0; i < arr.length - 1; i++) {
            maxReach = Math.max(maxReach, i + arr[i]);  // update the maximum reachable index

            if (i == steps) {  // if we have reached the end of the steps from the previous jump
                jumps++;  // increment the jump count
                steps = maxReach;  // update the remaining steps to be taken as the maximum reachable index
            }

            if (i >= maxReach) {  // if we are stuck at a position with zero maximum reachable index
                return -1;  // unable to reach the end, return -1
            }
        }

        return jumps;  // return the minimum number of jumps
    }
}

/*
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
 */
public class _02_climbing_stairs_min_cost {
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // int one = cost[n-2];
        // int two = cost[n-1];
        int one = 0, two = 0;

        for (int i = n-1; i >= 0; i--) {
            int temp = cost[i] + Math.min(one, two);
            two = one;
            one = temp;
        }
        return Math.min(one,two);
    }
}

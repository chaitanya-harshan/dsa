public class _01_climbing_stairs {
    
    public static void main(String[] args) {
        System.out.println(climbStairs(12));
        System.out.println(climbStairs(1));

    }

    static int climbStairs(int n) {
        int nxt = 1;
        int nxtNxt = 0;
        int cur = 0;

        for (int i = n; i > 0; i--) {
            cur = nxt + nxtNxt;
            nxtNxt = nxt;
            nxt = cur;
        }
        return cur;
    }
}

/*https://leetcode.com/problems/climbing-stairs/description/

 * 70. Climbing Stairs
 * 
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45

 */
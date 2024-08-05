import java.util.HashMap;

/**
 * climbing_stairs
 * 
 * https://www.youtube.com/watch?v=Y0lT9Fck7qI
 */

// bottom up aproach dp problem

/*
 *                           u
 *                         u u
 *                       u u u
 *                     u u u u
 *                   u u u u u
 * 
 *               _0_ 1 2 3 4 5
 * Diff paths -    8 5 3 2 (1 1)
 *                     |    | |
 *       [One + two]3 = 2+1 | |
 *                         one|
 *                           two
 */

public class climbing_stairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }


    // bottom up optimal
    public static int climbStairs(int n) {
        int one = 1, two = 1;
        for (int i=n-1; i>0; i--
        ) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }

    // bottom up - storing all the vlaues in array
    public int climbStairs1(int n) {
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = 1;

        for (int i = n-2; i>=0; i--) {
            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];
    } 


    // Using Recursion (and HashMap to not do path finds which are already found


    //                                  0
    //                  1_______________________________2
    //            2----------------3               3------------4
    //       3--------4         4    {5}        4     {5}    {5}  *6*
    //     4-{5}   {5}--6   {5}---*6*       {5}   *6*
    // {5}---*6*

    public static int climbStairs2(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return paths(0, n, map);
    }

    public static int paths(int k, int n, HashMap<Integer,Integer> map) {
        if (map.containsKey(k)) return map.get(k);

        if (k == n) return 1;
        if (k > n) return 0;

        int one = paths(k+1, n, map);
        int two = paths(k+2, n, map);

        map.put(k, one + two);

        return one+two;
    }
}
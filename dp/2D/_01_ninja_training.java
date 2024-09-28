/**
 * _01_ninja_training
 */
public class _01_ninja_training {

    public int maximumPoints(int arr[][], int N) {
        // code here
        int dp[][] = new int[N+1][3];
        // dp[N-1] = {arr[N-1][0], arr[N-1][1], arr[N-1][2] };
        
        for (int i=N+1-2; i>=0; i--) {
            for (int j=0; j<3; j++) {
                
                int cur = 0;
                for (int k=0; k<3; k++) {
                    if (k != j) {
                        cur = Math.max(arr[i][j]+dp[i+1][k], cur);
                    }
                }
                dp[i][j] = cur;
            }
        }
        
        return Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));
    }
}

/*
 * A Ninja has an ‘N’ Day training schedule. 
 * He has to perform one of these three activities (Running, Fighting Practice, 
 * or Learning New Moves) each day. There are merit points associated with performing an activity each day. The same activity can’t be performed on two consecutive days. We need to find the maximum merit points the ninja can attain in N Days.

We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point 
of specific activity on that particular day. Our task is to calculate the maximum 
number of merit points that the ninja can earn.

Examples:

Input: n=3 and arr[]= [[1,2,5],[3,1,1],[3,3,3]]
Output:11

3
10 40 70
20 50 80
30 60 90

Output - 210
 */
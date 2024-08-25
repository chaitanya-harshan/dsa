package bit_manipulation.easy;

public class _05_count_total_set_bits_1_to_N {
    
    public static int countSetBits(int n){
        // int[] dp = new int[n+1];
        // dp[0] = 0;
        
        // int cur2thPow = 0;
        // int nxt2thPow = 1;
        // int cnt = 0;
        
        // for (int i = 1; i<dp.length; i++) {
        //     if (i == nxt2thPow) {
        //         dp[i] = 1;
        //         cur2thPow = nxt2thPow;
        //         nxt2thPow *= 2;
        //         cnt += dp[i];
        //     }
        //     else {
        //         dp[i] = 1 + dp[i - cur2thPow];
        //         cnt += dp[i];
        //     }
        // }
        
        // return cnt;


        int cnt = 0;
        while (n != 0) {
            cnt += count(n);
            n--;
        }
        return cnt;
        
    }
    
    static int count(int n){
        int cnt = 0;
        while (n != 0) {
            n = n-1 & n;
            cnt++;
        }
        return cnt;
    }
}

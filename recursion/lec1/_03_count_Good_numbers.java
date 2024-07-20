package recursion.lec1;

public class _03_count_Good_numbers {

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(222));
    }
    
    static final long MOD = 1000000007; // 10^9 + 7

    public static int countGoodNumbers(long n) {
        long ans = pow(5, (n+1)/2) * pow(4, n/2) % MOD;
        return (int)ans;
    }

    private static long pow(long base, long exp) {
        base = base % MOD;
        if (exp == 0) return 1;
        if (exp == 1) return base;
        if (exp % 2 == 1) return base * pow(base, exp-1) % MOD;
        else {
            // long bro = base * base % MOD;
            // return pow(bro, exp/2) % MOD;
            return pow(base * base, exp/2) % MOD; 
        } 
    }
}

public class prime {
    public static void main(String[] args) {
        System.out.println( isPrime(1483) );
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

// Without Recursion
/*
    USING EUCLIDEAN ALGORITHM
 * Time complexity - O(  log( min(a,b) )    )
 */

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(15,10));
    }

    static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            // a -= b --> needs moe iterations of the loop when the a-b is large

            if (a > b)  a = a % b;
            else        b = b % a;

            // if (a == 0) return b;
            // if (b == 0) return a;
            // java wont let you to return 'only' from inside the loop
        }
        if (a == 0) return b;
        else return a;
    }
}




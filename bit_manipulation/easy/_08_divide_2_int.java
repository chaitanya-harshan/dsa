package bit_manipulation.easy;

public class _08_divide_2_int {
    
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(-8, 2));
        System.out.println(divide(7, -3));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;

        long quotient = 0;
        long d = Math.abs((long)dividend), dv = Math.abs((long)divisor);

        while (d >= dv) {
            int shift = 0;
            while (d >= (dv << (shift+1)) ) {
                shift++;
            }
            d -= (dv << shift);
            quotient += ((long)1 << shift);
        }

        int sign = 1;
        if (dividend<0 ^ divisor<0) sign = -1; // xor to check if only one is negative
        // if (dividend <= 0 && divisor > 0) sign = -1;
        // if (dividend >= 0 && divisor < 0) sign = -1;

        if (quotient > (1 << 31)-1 && sign == 1) return Integer.MAX_VALUE;
        if (quotient > ((long)1 << 31) && sign == -1) return Integer.MIN_VALUE;
        // i'm not if you'll understand this
        // here u know quotient will overflow in the code submittted before so u dirctlycheck for int min
        // if (quotient == (1 << 31) && sign == 1) return Integer.MAX_VALUE;
        // if (quotient == (1 << 31) && sign == -1) return Integer.MIN_VALUE;

        int q = (int)quotient;
        return sign == 1 ? q : -q;
    }
}

package bit_manipulation.easy;

public class _08_divide_2_int {
    
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(8, 2));
        System.out.println(divide(-8, 2));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        int quotient = 0;
        int d = Math.abs(dividend), dv = Math.abs(divisor);

        while (d >= dv) {
            int shift = 0;
            while (d >= (dv << shift)) {
                shift++;
            }
            shift--;
            d -= (dv << shift);
            quotient += (1 << shift);
        }

        if (dividend<0 ^ divisor<0) return Math.max(-1*quotient, Integer.MIN_VALUE);
        else return Math.min(quotient, Integer.MAX_VALUE);
    }
}

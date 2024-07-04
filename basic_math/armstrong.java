/**
 * armstrong
 */
public class armstrong {

    public static void main(String[] args) {
        System.out.println(  isArmstrong(371));
    }

    static boolean isArmstrong(int N) {
        int OG = N;
        int length = digits(N); // (int)Math.log10(N) + 1
        int sum = 0;

        while (N > 0) {
            int digit = N % 10;
            N /= 10;
            sum += Math.pow(digit, length);
        }
        
        return sum == OG ;
    }

    static int digits(int N) {
        // int noOfDigits = 0;
        // while (N > 0) {
        //     N /= 10;
        //     noOfDigits++;
        // }
        // return noOfDigits;

        return (int)Math.log10(N) + 1;
    }
}
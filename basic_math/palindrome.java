
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        System.out.println("Enter number:");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int OgNum = N;
        int revNum = 0;

        while (N > 0) {
            int digit = N % 10;
            N /= 10;
            revNum = revNum*10 + digit;
        }
        if (OgNum == revNum) {
            System.out.println("Yes, it's a palindrome");
        }
        else System.out.println("Not a palindrome");
    }
}

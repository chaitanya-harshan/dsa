package _extras.z_untracked;

import java.util.Scanner;

public class bit_flipper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();

        // System.out.println(Integer.bitCount(p^q^r));

        
        int XR = p^q^r;
        int flips = 0;
        while (XR > 0) {
            if ((XR & 1) == 1) flips++;
            XR >>= 1;
        }
        System.out.println(flips);
    }
}
